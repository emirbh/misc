package com.regnosys.drr;

import com.google.inject.Key;
import com.google.inject.name.Names;
import com.regnosys.model.functions.NoOpConditionValidator;
import com.rosetta.model.lib.functions.ConditionValidator;
import drr.base.trade.functions.Create_ContinuousPriceSchedule;
import drr.base.trade.functions.Create_ContinuousQuantitySchedule;
import drr.base.trade.functions.GetQuantityKeys;
import drr.base.trade.functions.GetQuantityReference;
import drr.base.util.string.functions.StringContains;
import drr.base.util.string.functions.StringLength;
import drr.base.util.string.functions.SubString;
import drr.enrichment.eic.functions.GetAcceptedEicCodes;
import drr.enrichment.eic.functions.GetAcceptedEicCodesImpl;
import drr.enrichment.upi.functions.FilterEntityIdByScheme;
import drr.enrichment.upi.functions.FilterEntityIdBySchemeImpl;
import drr.regulation.common.functions.Create_ContinuousPriceScheduleImpl;
import drr.regulation.common.functions.Create_ContinuousQuantityScheduleImpl;
import drr.regulation.common.functions.GetQuantityKeysImpl;
import drr.regulation.common.functions.GetQuantityReferenceImpl;
import drr.regulation.common.util.functions.StringContainsImpl;
import drr.regulation.common.util.functions.StringLengthImpl;
import drr.regulation.common.util.functions.SubStringImpl;
import drr.standards.iso.functions.ComputeLeiChecksum;
import drr.standards.iso.functions.ComputeLeiChecksumImpl;
import org.finos.cdm.CdmRuntimeModule;

public class DrrRuntimeModule extends CdmRuntimeModule {

    @Override
    protected void configure() {
        super.configure();
        bind(ConditionValidator.class).to(bindConditionValidator());

        bind(GetQuantityKeys.class).to(bindGetQuantityKeys());
        bind(GetQuantityReference.class).to(bindGetQuantityReference());
        bind(Create_ContinuousPriceSchedule.class).to(bindCreateContinuousPriceSchedule());
        bind(Create_ContinuousQuantitySchedule.class).to(bindCreateContinuousQuantitySchedule());
        bind(drr.regulation.common.functions.LimitBasketConstituents.class).to(drr.regulation.common.functions.LimitBasketConstituentsImpl.class);
        bind(drr.base.trade.functions.LimitBasketConstituents.class).to(drr.base.trade.functions.LimitBasketConstituentsImpl.class);
        bind(ComputeLeiChecksum.class).to(ComputeLeiChecksumImpl.class);

        bind(StringLength.class).to(bindStringLength());
        bind(SubString.class).to(bindSubString());
        bind(StringContains.class).to(bindStringContains());
        bind(FilterEntityIdByScheme.class).to(bindFilterEntityIdByScheme());

        bind(GetAcceptedEicCodes.class).to(bindGetAcceptedEicCodes()).asEagerSingleton();
        bind(Key.get(String.class, Names.named(GetAcceptedEicCodesImpl.ACCEPTED_EIC_CODES_PATH)))
                .toInstance(GetAcceptedEicCodesImpl.ACCEPTED_EIC_CODES_CSV);
    }

    protected Class<? extends GetQuantityKeys> bindGetQuantityKeys() {
        return GetQuantityKeysImpl.class;
    }

    protected Class<? extends GetQuantityReference> bindGetQuantityReference() {
        return GetQuantityReferenceImpl.class;
    }

    protected Class<? extends Create_ContinuousPriceSchedule> bindCreateContinuousPriceSchedule() {
        return Create_ContinuousPriceScheduleImpl.class;
    }

    protected Class<? extends Create_ContinuousQuantitySchedule> bindCreateContinuousQuantitySchedule() {
        return Create_ContinuousQuantityScheduleImpl.class;
    }

    protected Class<? extends ConditionValidator> bindConditionValidator() {
        return NoOpConditionValidator.class;
    }

    protected Class<? extends StringLength> bindStringLength() {
        return StringLengthImpl.class;
    }

    protected Class<? extends SubString> bindSubString() {
        return SubStringImpl.class;
    }

    protected Class<? extends StringContains> bindStringContains() {
        return StringContainsImpl.class;
    }

    protected Class<? extends FilterEntityIdByScheme> bindFilterEntityIdByScheme() {
        return FilterEntityIdBySchemeImpl.class;
    }

    protected Class<? extends GetAcceptedEicCodes> bindGetAcceptedEicCodes() {
        return GetAcceptedEicCodesImpl.class;
    }
}