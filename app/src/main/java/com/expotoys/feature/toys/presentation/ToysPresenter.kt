package com.expotoys.feature.toys.presentation

import com.expotoys.common.core.data.repository.toy.ToysRepository
import com.expotoys.common.core.view.lifecycle.LifecycleView
import com.expotoys.common.core.view.presentation.LifecyclePresenter

class ToysPresenter(
    private val repository: ToysRepository
): LifecyclePresenter<ToysPresenter.View>() {
    override fun onViewAttached(firstTime: Boolean) {
        view?.showImage("https://lh3.googleusercontent.com/ZvgZmgcWji1W-WL9O4XrEc-GrFeN-6-xUEJmEKprY_6Fa_uovqV2ZYVnz9bq0Kg3u_QQUA3hpiNYK5qN3GyeJlNpjcRlLn2sMFNE3tV_VmXarYWMbjFHgALTFteV_2tOMVzDMz_pcPt8D-amrxDUTlyC6lnhgOWBmED78xlTxseps3mAsTcD2hOgI7m2oAhxQQ4PttLsd42Vbuk5MTp5mbOSv1VL-5dC6-vw8qNM9WQbPjaozDyN6xOTRKP9WJZhbxC8bAmjHd6pqxIsYW5DbHvMZckmmjCCjYQvEJ0pA2OFgoqr3YkcUZsOkbIP_vbL-2TMgxxDTtaFjzaDI3O4rl5NTNSjFREUdikmJw60pn4YBToKAjn_BtGSVpuke0gzxnoGVImGnOlR6ZB-5Nsm925_OkaLlT__M3fQfA-eAlZUVOBtYazdDUJtwxEjLVYiv1HgTpK5zXDNOO3Xpk_DcawjXN3DW4sGhU-kXrWPAVHMYym4dnMLsnPCbd0WGLXzXXhrCvgGY2sQZKEDQJWyAb8eUHi6tj2LaxetnP81rGQ4pKh9sCjsGkStlTD9mKum7AEXNms3FWbAqbxjcYP0UUHKSVb7FecJplav7H9fEVtbp4aijDev-cVdHyUqiaw_M3rm2lvydy4wck1I33_DFswJPNw2NDE=w1912-h1434-no")
    }

    interface View : LifecycleView {
        fun showImage(url: String)
    }
}
