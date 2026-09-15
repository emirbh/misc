package fpml.consolidated.ird;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.ird.meta.CashSettlementMeta;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type to define the cash settlement terms for a product where cash settlement is applicable.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type to define the cash settlement terms for a product where cash settlement is applicable.
 *
 */
@RosettaDataType(value="CashSettlement", builder=CashSettlement.CashSettlementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CashSettlement", model="fpml", builder=CashSettlement.CashSettlementBuilderImpl.class, version="2.1.1")
public interface CashSettlement extends RosettaModelObject {

	CashSettlementMeta metaData = new CashSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time of the cash settlement valuation date when the cash settlement amount will be determined according to the cash settlement method if the parties have not otherwise been able to agree the cash settlement amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time of the cash settlement valuation date when the cash settlement amount will be determined according to the cash settlement method if the parties have not otherwise been able to agree the cash settlement amount.
	 *
	 */
	BusinessCenterTime getCashSettlementValuationTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the cash settlement amount will be determined according to the cash settlement method if the parties have not otherwise been able to agree the cash settlement amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the cash settlement amount will be determined according to the cash settlement method if the parties have not otherwise been able to agree the cash settlement amount.
	 *
	 */
	RelativeDateOffset getCashSettlementValuationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the cash settlement amount will be paid, subject to adjustment in accordance with any applicable business day convention. This component would not be present for a mandatory early termination provision where the cash settlement payment date is the mandatory early termination date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the cash settlement amount will be paid, subject to adjustment in accordance with any applicable business day convention. This component would not be present for a mandatory early termination provision where the cash settlement payment date is the mandatory early termination date.
	 *
	 */
	CashSettlementPaymentDate getCashSettlementPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision ISDA defined cash settlement methods based on mid-market valuation. These methods are defined in the 2021 ISDA Definitions, Section 18.2.1-3, Cash Settlement Methods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision ISDA defined cash settlement methods based on mid-market valuation. These methods are defined in the 2021 ISDA Definitions, Section 18.2.1-3, Cash Settlement Methods.
	 *
	 */
	MidMarketValuation getMidMarketValuation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision ISDA defined cash settlement methods based on replacement value. These methods are defined in the 2021 ISDA Definitions, Section 18.2.4-5, Cash Settlement Methods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision ISDA defined cash settlement methods based on replacement value. These methods are defined in the 2021 ISDA Definitions, Section 18.2.4-5, Cash Settlement Methods.
	 *
	 */
	ReplacementValue getReplacementValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. This method is defined in the 2021 ISDA Definitions, section 18.2.7. The method is also defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (e).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. This method is defined in the 2021 ISDA Definitions, section 18.2.7. The method is also defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (e).
	 *
	 */
	YieldCurveMethod getParYieldCurveUnadjustedMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.6. Note: the 2021 Definition has different fields than appeared in the 2006 Definitions; this sctructure handles both methods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.6. Note: the 2021 Definition has different fields than appeared in the 2006 Definitions; this sctructure handles both methods.
	 *
	 */
	CollateralizedCashPriceMethod getCollateralizedCashPriceMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (a).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (a).
	 *
	 */
	CashPriceMethod getCashPriceMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (b).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (b).
	 *
	 */
	CashPriceMethod getCashPriceAlternateMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (c).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (c).
	 *
	 */
	YieldCurveMethod getParYieldCurveAdjustedMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (d).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (d).
	 *
	 */
	YieldCurveMethod getZeroCouponYieldAdjustedMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (f) (published in Supplement number 58).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (f) (published in Supplement number 58).
	 *
	 */
	CrossCurrencyMethod getCrossCurrencyMethod();

	/*********************** Build Methods  ***********************/
	CashSettlement build();
	
	CashSettlement.CashSettlementBuilder toBuilder();
	
	static CashSettlement.CashSettlementBuilder builder() {
		return new CashSettlement.CashSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashSettlement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CashSettlement> getType() {
		return CashSettlement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("cashSettlementValuationTime"), processor, BusinessCenterTime.class, getCashSettlementValuationTime());
		processRosetta(path.newSubPath("cashSettlementValuationDate"), processor, RelativeDateOffset.class, getCashSettlementValuationDate());
		processRosetta(path.newSubPath("cashSettlementPaymentDate"), processor, CashSettlementPaymentDate.class, getCashSettlementPaymentDate());
		processRosetta(path.newSubPath("midMarketValuation"), processor, MidMarketValuation.class, getMidMarketValuation());
		processRosetta(path.newSubPath("replacementValue"), processor, ReplacementValue.class, getReplacementValue());
		processRosetta(path.newSubPath("parYieldCurveUnadjustedMethod"), processor, YieldCurveMethod.class, getParYieldCurveUnadjustedMethod());
		processRosetta(path.newSubPath("collateralizedCashPriceMethod"), processor, CollateralizedCashPriceMethod.class, getCollateralizedCashPriceMethod());
		processRosetta(path.newSubPath("cashPriceMethod"), processor, CashPriceMethod.class, getCashPriceMethod());
		processRosetta(path.newSubPath("cashPriceAlternateMethod"), processor, CashPriceMethod.class, getCashPriceAlternateMethod());
		processRosetta(path.newSubPath("parYieldCurveAdjustedMethod"), processor, YieldCurveMethod.class, getParYieldCurveAdjustedMethod());
		processRosetta(path.newSubPath("zeroCouponYieldAdjustedMethod"), processor, YieldCurveMethod.class, getZeroCouponYieldAdjustedMethod());
		processRosetta(path.newSubPath("crossCurrencyMethod"), processor, CrossCurrencyMethod.class, getCrossCurrencyMethod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashSettlementBuilder extends CashSettlement, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateCashSettlementValuationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getCashSettlementValuationTime();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateCashSettlementValuationDate();
		@Override
		RelativeDateOffset.RelativeDateOffsetBuilder getCashSettlementValuationDate();
		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder getOrCreateCashSettlementPaymentDate();
		@Override
		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder getCashSettlementPaymentDate();
		MidMarketValuation.MidMarketValuationBuilder getOrCreateMidMarketValuation();
		@Override
		MidMarketValuation.MidMarketValuationBuilder getMidMarketValuation();
		ReplacementValue.ReplacementValueBuilder getOrCreateReplacementValue();
		@Override
		ReplacementValue.ReplacementValueBuilder getReplacementValue();
		YieldCurveMethod.YieldCurveMethodBuilder getOrCreateParYieldCurveUnadjustedMethod();
		@Override
		YieldCurveMethod.YieldCurveMethodBuilder getParYieldCurveUnadjustedMethod();
		CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder getOrCreateCollateralizedCashPriceMethod();
		@Override
		CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder getCollateralizedCashPriceMethod();
		CashPriceMethod.CashPriceMethodBuilder getOrCreateCashPriceMethod();
		@Override
		CashPriceMethod.CashPriceMethodBuilder getCashPriceMethod();
		CashPriceMethod.CashPriceMethodBuilder getOrCreateCashPriceAlternateMethod();
		@Override
		CashPriceMethod.CashPriceMethodBuilder getCashPriceAlternateMethod();
		YieldCurveMethod.YieldCurveMethodBuilder getOrCreateParYieldCurveAdjustedMethod();
		@Override
		YieldCurveMethod.YieldCurveMethodBuilder getParYieldCurveAdjustedMethod();
		YieldCurveMethod.YieldCurveMethodBuilder getOrCreateZeroCouponYieldAdjustedMethod();
		@Override
		YieldCurveMethod.YieldCurveMethodBuilder getZeroCouponYieldAdjustedMethod();
		CrossCurrencyMethod.CrossCurrencyMethodBuilder getOrCreateCrossCurrencyMethod();
		@Override
		CrossCurrencyMethod.CrossCurrencyMethodBuilder getCrossCurrencyMethod();
		CashSettlement.CashSettlementBuilder setId(String id);
		CashSettlement.CashSettlementBuilder setCashSettlementValuationTime(BusinessCenterTime cashSettlementValuationTime);
		CashSettlement.CashSettlementBuilder setCashSettlementValuationDate(RelativeDateOffset cashSettlementValuationDate);
		CashSettlement.CashSettlementBuilder setCashSettlementPaymentDate(CashSettlementPaymentDate cashSettlementPaymentDate);
		CashSettlement.CashSettlementBuilder setMidMarketValuation(MidMarketValuation midMarketValuation);
		CashSettlement.CashSettlementBuilder setReplacementValue(ReplacementValue replacementValue);
		CashSettlement.CashSettlementBuilder setParYieldCurveUnadjustedMethod(YieldCurveMethod parYieldCurveUnadjustedMethod);
		CashSettlement.CashSettlementBuilder setCollateralizedCashPriceMethod(CollateralizedCashPriceMethod collateralizedCashPriceMethod);
		CashSettlement.CashSettlementBuilder setCashPriceMethod(CashPriceMethod cashPriceMethod);
		CashSettlement.CashSettlementBuilder setCashPriceAlternateMethod(CashPriceMethod cashPriceAlternateMethod);
		CashSettlement.CashSettlementBuilder setParYieldCurveAdjustedMethod(YieldCurveMethod parYieldCurveAdjustedMethod);
		CashSettlement.CashSettlementBuilder setZeroCouponYieldAdjustedMethod(YieldCurveMethod zeroCouponYieldAdjustedMethod);
		CashSettlement.CashSettlementBuilder setCrossCurrencyMethod(CrossCurrencyMethod crossCurrencyMethod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("cashSettlementValuationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getCashSettlementValuationTime());
			processRosetta(path.newSubPath("cashSettlementValuationDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getCashSettlementValuationDate());
			processRosetta(path.newSubPath("cashSettlementPaymentDate"), processor, CashSettlementPaymentDate.CashSettlementPaymentDateBuilder.class, getCashSettlementPaymentDate());
			processRosetta(path.newSubPath("midMarketValuation"), processor, MidMarketValuation.MidMarketValuationBuilder.class, getMidMarketValuation());
			processRosetta(path.newSubPath("replacementValue"), processor, ReplacementValue.ReplacementValueBuilder.class, getReplacementValue());
			processRosetta(path.newSubPath("parYieldCurveUnadjustedMethod"), processor, YieldCurveMethod.YieldCurveMethodBuilder.class, getParYieldCurveUnadjustedMethod());
			processRosetta(path.newSubPath("collateralizedCashPriceMethod"), processor, CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder.class, getCollateralizedCashPriceMethod());
			processRosetta(path.newSubPath("cashPriceMethod"), processor, CashPriceMethod.CashPriceMethodBuilder.class, getCashPriceMethod());
			processRosetta(path.newSubPath("cashPriceAlternateMethod"), processor, CashPriceMethod.CashPriceMethodBuilder.class, getCashPriceAlternateMethod());
			processRosetta(path.newSubPath("parYieldCurveAdjustedMethod"), processor, YieldCurveMethod.YieldCurveMethodBuilder.class, getParYieldCurveAdjustedMethod());
			processRosetta(path.newSubPath("zeroCouponYieldAdjustedMethod"), processor, YieldCurveMethod.YieldCurveMethodBuilder.class, getZeroCouponYieldAdjustedMethod());
			processRosetta(path.newSubPath("crossCurrencyMethod"), processor, CrossCurrencyMethod.CrossCurrencyMethodBuilder.class, getCrossCurrencyMethod());
		}
		

		CashSettlement.CashSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of CashSettlement  ***********************/
	class CashSettlementImpl implements CashSettlement {
		private final String id;
		private final BusinessCenterTime cashSettlementValuationTime;
		private final RelativeDateOffset cashSettlementValuationDate;
		private final CashSettlementPaymentDate cashSettlementPaymentDate;
		private final MidMarketValuation midMarketValuation;
		private final ReplacementValue replacementValue;
		private final YieldCurveMethod parYieldCurveUnadjustedMethod;
		private final CollateralizedCashPriceMethod collateralizedCashPriceMethod;
		private final CashPriceMethod cashPriceMethod;
		private final CashPriceMethod cashPriceAlternateMethod;
		private final YieldCurveMethod parYieldCurveAdjustedMethod;
		private final YieldCurveMethod zeroCouponYieldAdjustedMethod;
		private final CrossCurrencyMethod crossCurrencyMethod;
		
		protected CashSettlementImpl(CashSettlement.CashSettlementBuilder builder) {
			this.id = builder.getId();
			this.cashSettlementValuationTime = ofNullable(builder.getCashSettlementValuationTime()).map(f->f.build()).orElse(null);
			this.cashSettlementValuationDate = ofNullable(builder.getCashSettlementValuationDate()).map(f->f.build()).orElse(null);
			this.cashSettlementPaymentDate = ofNullable(builder.getCashSettlementPaymentDate()).map(f->f.build()).orElse(null);
			this.midMarketValuation = ofNullable(builder.getMidMarketValuation()).map(f->f.build()).orElse(null);
			this.replacementValue = ofNullable(builder.getReplacementValue()).map(f->f.build()).orElse(null);
			this.parYieldCurveUnadjustedMethod = ofNullable(builder.getParYieldCurveUnadjustedMethod()).map(f->f.build()).orElse(null);
			this.collateralizedCashPriceMethod = ofNullable(builder.getCollateralizedCashPriceMethod()).map(f->f.build()).orElse(null);
			this.cashPriceMethod = ofNullable(builder.getCashPriceMethod()).map(f->f.build()).orElse(null);
			this.cashPriceAlternateMethod = ofNullable(builder.getCashPriceAlternateMethod()).map(f->f.build()).orElse(null);
			this.parYieldCurveAdjustedMethod = ofNullable(builder.getParYieldCurveAdjustedMethod()).map(f->f.build()).orElse(null);
			this.zeroCouponYieldAdjustedMethod = ofNullable(builder.getZeroCouponYieldAdjustedMethod()).map(f->f.build()).orElse(null);
			this.crossCurrencyMethod = ofNullable(builder.getCrossCurrencyMethod()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("cashSettlementValuationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementValuationTime")
		public BusinessCenterTime getCashSettlementValuationTime() {
			return cashSettlementValuationTime;
		}
		
		@Override
		@RosettaAttribute("cashSettlementValuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementValuationDate")
		public RelativeDateOffset getCashSettlementValuationDate() {
			return cashSettlementValuationDate;
		}
		
		@Override
		@RosettaAttribute("cashSettlementPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementPaymentDate")
		public CashSettlementPaymentDate getCashSettlementPaymentDate() {
			return cashSettlementPaymentDate;
		}
		
		@Override
		@RosettaAttribute("midMarketValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("midMarketValuation")
		public MidMarketValuation getMidMarketValuation() {
			return midMarketValuation;
		}
		
		@Override
		@RosettaAttribute("replacementValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("replacementValue")
		public ReplacementValue getReplacementValue() {
			return replacementValue;
		}
		
		@Override
		@RosettaAttribute("parYieldCurveUnadjustedMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parYieldCurveUnadjustedMethod")
		public YieldCurveMethod getParYieldCurveUnadjustedMethod() {
			return parYieldCurveUnadjustedMethod;
		}
		
		@Override
		@RosettaAttribute("collateralizedCashPriceMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralizedCashPriceMethod")
		public CollateralizedCashPriceMethod getCollateralizedCashPriceMethod() {
			return collateralizedCashPriceMethod;
		}
		
		@Override
		@RosettaAttribute("cashPriceMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashPriceMethod")
		public CashPriceMethod getCashPriceMethod() {
			return cashPriceMethod;
		}
		
		@Override
		@RosettaAttribute("cashPriceAlternateMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashPriceAlternateMethod")
		public CashPriceMethod getCashPriceAlternateMethod() {
			return cashPriceAlternateMethod;
		}
		
		@Override
		@RosettaAttribute("parYieldCurveAdjustedMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parYieldCurveAdjustedMethod")
		public YieldCurveMethod getParYieldCurveAdjustedMethod() {
			return parYieldCurveAdjustedMethod;
		}
		
		@Override
		@RosettaAttribute("zeroCouponYieldAdjustedMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("zeroCouponYieldAdjustedMethod")
		public YieldCurveMethod getZeroCouponYieldAdjustedMethod() {
			return zeroCouponYieldAdjustedMethod;
		}
		
		@Override
		@RosettaAttribute("crossCurrencyMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crossCurrencyMethod")
		public CrossCurrencyMethod getCrossCurrencyMethod() {
			return crossCurrencyMethod;
		}
		
		@Override
		public CashSettlement build() {
			return this;
		}
		
		@Override
		public CashSettlement.CashSettlementBuilder toBuilder() {
			CashSettlement.CashSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashSettlement.CashSettlementBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCashSettlementValuationTime()).ifPresent(builder::setCashSettlementValuationTime);
			ofNullable(getCashSettlementValuationDate()).ifPresent(builder::setCashSettlementValuationDate);
			ofNullable(getCashSettlementPaymentDate()).ifPresent(builder::setCashSettlementPaymentDate);
			ofNullable(getMidMarketValuation()).ifPresent(builder::setMidMarketValuation);
			ofNullable(getReplacementValue()).ifPresent(builder::setReplacementValue);
			ofNullable(getParYieldCurveUnadjustedMethod()).ifPresent(builder::setParYieldCurveUnadjustedMethod);
			ofNullable(getCollateralizedCashPriceMethod()).ifPresent(builder::setCollateralizedCashPriceMethod);
			ofNullable(getCashPriceMethod()).ifPresent(builder::setCashPriceMethod);
			ofNullable(getCashPriceAlternateMethod()).ifPresent(builder::setCashPriceAlternateMethod);
			ofNullable(getParYieldCurveAdjustedMethod()).ifPresent(builder::setParYieldCurveAdjustedMethod);
			ofNullable(getZeroCouponYieldAdjustedMethod()).ifPresent(builder::setZeroCouponYieldAdjustedMethod);
			ofNullable(getCrossCurrencyMethod()).ifPresent(builder::setCrossCurrencyMethod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlement _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(cashSettlementValuationTime, _that.getCashSettlementValuationTime())) return false;
			if (!Objects.equals(cashSettlementValuationDate, _that.getCashSettlementValuationDate())) return false;
			if (!Objects.equals(cashSettlementPaymentDate, _that.getCashSettlementPaymentDate())) return false;
			if (!Objects.equals(midMarketValuation, _that.getMidMarketValuation())) return false;
			if (!Objects.equals(replacementValue, _that.getReplacementValue())) return false;
			if (!Objects.equals(parYieldCurveUnadjustedMethod, _that.getParYieldCurveUnadjustedMethod())) return false;
			if (!Objects.equals(collateralizedCashPriceMethod, _that.getCollateralizedCashPriceMethod())) return false;
			if (!Objects.equals(cashPriceMethod, _that.getCashPriceMethod())) return false;
			if (!Objects.equals(cashPriceAlternateMethod, _that.getCashPriceAlternateMethod())) return false;
			if (!Objects.equals(parYieldCurveAdjustedMethod, _that.getParYieldCurveAdjustedMethod())) return false;
			if (!Objects.equals(zeroCouponYieldAdjustedMethod, _that.getZeroCouponYieldAdjustedMethod())) return false;
			if (!Objects.equals(crossCurrencyMethod, _that.getCrossCurrencyMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (cashSettlementValuationTime != null ? cashSettlementValuationTime.hashCode() : 0);
			_result = 31 * _result + (cashSettlementValuationDate != null ? cashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (cashSettlementPaymentDate != null ? cashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (midMarketValuation != null ? midMarketValuation.hashCode() : 0);
			_result = 31 * _result + (replacementValue != null ? replacementValue.hashCode() : 0);
			_result = 31 * _result + (parYieldCurveUnadjustedMethod != null ? parYieldCurveUnadjustedMethod.hashCode() : 0);
			_result = 31 * _result + (collateralizedCashPriceMethod != null ? collateralizedCashPriceMethod.hashCode() : 0);
			_result = 31 * _result + (cashPriceMethod != null ? cashPriceMethod.hashCode() : 0);
			_result = 31 * _result + (cashPriceAlternateMethod != null ? cashPriceAlternateMethod.hashCode() : 0);
			_result = 31 * _result + (parYieldCurveAdjustedMethod != null ? parYieldCurveAdjustedMethod.hashCode() : 0);
			_result = 31 * _result + (zeroCouponYieldAdjustedMethod != null ? zeroCouponYieldAdjustedMethod.hashCode() : 0);
			_result = 31 * _result + (crossCurrencyMethod != null ? crossCurrencyMethod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlement {" +
				"id=" + this.id + ", " +
				"cashSettlementValuationTime=" + this.cashSettlementValuationTime + ", " +
				"cashSettlementValuationDate=" + this.cashSettlementValuationDate + ", " +
				"cashSettlementPaymentDate=" + this.cashSettlementPaymentDate + ", " +
				"midMarketValuation=" + this.midMarketValuation + ", " +
				"replacementValue=" + this.replacementValue + ", " +
				"parYieldCurveUnadjustedMethod=" + this.parYieldCurveUnadjustedMethod + ", " +
				"collateralizedCashPriceMethod=" + this.collateralizedCashPriceMethod + ", " +
				"cashPriceMethod=" + this.cashPriceMethod + ", " +
				"cashPriceAlternateMethod=" + this.cashPriceAlternateMethod + ", " +
				"parYieldCurveAdjustedMethod=" + this.parYieldCurveAdjustedMethod + ", " +
				"zeroCouponYieldAdjustedMethod=" + this.zeroCouponYieldAdjustedMethod + ", " +
				"crossCurrencyMethod=" + this.crossCurrencyMethod +
			'}';
		}
	}

	/*********************** Builder Implementation of CashSettlement  ***********************/
	class CashSettlementBuilderImpl implements CashSettlement.CashSettlementBuilder {
	
		protected String id;
		protected BusinessCenterTime.BusinessCenterTimeBuilder cashSettlementValuationTime;
		protected RelativeDateOffset.RelativeDateOffsetBuilder cashSettlementValuationDate;
		protected CashSettlementPaymentDate.CashSettlementPaymentDateBuilder cashSettlementPaymentDate;
		protected MidMarketValuation.MidMarketValuationBuilder midMarketValuation;
		protected ReplacementValue.ReplacementValueBuilder replacementValue;
		protected YieldCurveMethod.YieldCurveMethodBuilder parYieldCurveUnadjustedMethod;
		protected CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder collateralizedCashPriceMethod;
		protected CashPriceMethod.CashPriceMethodBuilder cashPriceMethod;
		protected CashPriceMethod.CashPriceMethodBuilder cashPriceAlternateMethod;
		protected YieldCurveMethod.YieldCurveMethodBuilder parYieldCurveAdjustedMethod;
		protected YieldCurveMethod.YieldCurveMethodBuilder zeroCouponYieldAdjustedMethod;
		protected CrossCurrencyMethod.CrossCurrencyMethodBuilder crossCurrencyMethod;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("cashSettlementValuationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementValuationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getCashSettlementValuationTime() {
			return cashSettlementValuationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateCashSettlementValuationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (cashSettlementValuationTime!=null) {
				result = cashSettlementValuationTime;
			}
			else {
				result = cashSettlementValuationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlementValuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementValuationDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getCashSettlementValuationDate() {
			return cashSettlementValuationDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateCashSettlementValuationDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (cashSettlementValuationDate!=null) {
				result = cashSettlementValuationDate;
			}
			else {
				result = cashSettlementValuationDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlementPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementPaymentDate")
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder getCashSettlementPaymentDate() {
			return cashSettlementPaymentDate;
		}
		
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder getOrCreateCashSettlementPaymentDate() {
			CashSettlementPaymentDate.CashSettlementPaymentDateBuilder result;
			if (cashSettlementPaymentDate!=null) {
				result = cashSettlementPaymentDate;
			}
			else {
				result = cashSettlementPaymentDate = CashSettlementPaymentDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("midMarketValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("midMarketValuation")
		public MidMarketValuation.MidMarketValuationBuilder getMidMarketValuation() {
			return midMarketValuation;
		}
		
		@Override
		public MidMarketValuation.MidMarketValuationBuilder getOrCreateMidMarketValuation() {
			MidMarketValuation.MidMarketValuationBuilder result;
			if (midMarketValuation!=null) {
				result = midMarketValuation;
			}
			else {
				result = midMarketValuation = MidMarketValuation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("replacementValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("replacementValue")
		public ReplacementValue.ReplacementValueBuilder getReplacementValue() {
			return replacementValue;
		}
		
		@Override
		public ReplacementValue.ReplacementValueBuilder getOrCreateReplacementValue() {
			ReplacementValue.ReplacementValueBuilder result;
			if (replacementValue!=null) {
				result = replacementValue;
			}
			else {
				result = replacementValue = ReplacementValue.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("parYieldCurveUnadjustedMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parYieldCurveUnadjustedMethod")
		public YieldCurveMethod.YieldCurveMethodBuilder getParYieldCurveUnadjustedMethod() {
			return parYieldCurveUnadjustedMethod;
		}
		
		@Override
		public YieldCurveMethod.YieldCurveMethodBuilder getOrCreateParYieldCurveUnadjustedMethod() {
			YieldCurveMethod.YieldCurveMethodBuilder result;
			if (parYieldCurveUnadjustedMethod!=null) {
				result = parYieldCurveUnadjustedMethod;
			}
			else {
				result = parYieldCurveUnadjustedMethod = YieldCurveMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralizedCashPriceMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralizedCashPriceMethod")
		public CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder getCollateralizedCashPriceMethod() {
			return collateralizedCashPriceMethod;
		}
		
		@Override
		public CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder getOrCreateCollateralizedCashPriceMethod() {
			CollateralizedCashPriceMethod.CollateralizedCashPriceMethodBuilder result;
			if (collateralizedCashPriceMethod!=null) {
				result = collateralizedCashPriceMethod;
			}
			else {
				result = collateralizedCashPriceMethod = CollateralizedCashPriceMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashPriceMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashPriceMethod")
		public CashPriceMethod.CashPriceMethodBuilder getCashPriceMethod() {
			return cashPriceMethod;
		}
		
		@Override
		public CashPriceMethod.CashPriceMethodBuilder getOrCreateCashPriceMethod() {
			CashPriceMethod.CashPriceMethodBuilder result;
			if (cashPriceMethod!=null) {
				result = cashPriceMethod;
			}
			else {
				result = cashPriceMethod = CashPriceMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashPriceAlternateMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashPriceAlternateMethod")
		public CashPriceMethod.CashPriceMethodBuilder getCashPriceAlternateMethod() {
			return cashPriceAlternateMethod;
		}
		
		@Override
		public CashPriceMethod.CashPriceMethodBuilder getOrCreateCashPriceAlternateMethod() {
			CashPriceMethod.CashPriceMethodBuilder result;
			if (cashPriceAlternateMethod!=null) {
				result = cashPriceAlternateMethod;
			}
			else {
				result = cashPriceAlternateMethod = CashPriceMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("parYieldCurveAdjustedMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parYieldCurveAdjustedMethod")
		public YieldCurveMethod.YieldCurveMethodBuilder getParYieldCurveAdjustedMethod() {
			return parYieldCurveAdjustedMethod;
		}
		
		@Override
		public YieldCurveMethod.YieldCurveMethodBuilder getOrCreateParYieldCurveAdjustedMethod() {
			YieldCurveMethod.YieldCurveMethodBuilder result;
			if (parYieldCurveAdjustedMethod!=null) {
				result = parYieldCurveAdjustedMethod;
			}
			else {
				result = parYieldCurveAdjustedMethod = YieldCurveMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("zeroCouponYieldAdjustedMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("zeroCouponYieldAdjustedMethod")
		public YieldCurveMethod.YieldCurveMethodBuilder getZeroCouponYieldAdjustedMethod() {
			return zeroCouponYieldAdjustedMethod;
		}
		
		@Override
		public YieldCurveMethod.YieldCurveMethodBuilder getOrCreateZeroCouponYieldAdjustedMethod() {
			YieldCurveMethod.YieldCurveMethodBuilder result;
			if (zeroCouponYieldAdjustedMethod!=null) {
				result = zeroCouponYieldAdjustedMethod;
			}
			else {
				result = zeroCouponYieldAdjustedMethod = YieldCurveMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("crossCurrencyMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crossCurrencyMethod")
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder getCrossCurrencyMethod() {
			return crossCurrencyMethod;
		}
		
		@Override
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder getOrCreateCrossCurrencyMethod() {
			CrossCurrencyMethod.CrossCurrencyMethodBuilder result;
			if (crossCurrencyMethod!=null) {
				result = crossCurrencyMethod;
			}
			else {
				result = crossCurrencyMethod = CrossCurrencyMethod.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CashSettlement.CashSettlementBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("cashSettlementValuationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementValuationTime")
		@Override
		public CashSettlement.CashSettlementBuilder setCashSettlementValuationTime(BusinessCenterTime _cashSettlementValuationTime) {
			this.cashSettlementValuationTime = _cashSettlementValuationTime == null ? null : _cashSettlementValuationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashSettlementValuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementValuationDate")
		@Override
		public CashSettlement.CashSettlementBuilder setCashSettlementValuationDate(RelativeDateOffset _cashSettlementValuationDate) {
			this.cashSettlementValuationDate = _cashSettlementValuationDate == null ? null : _cashSettlementValuationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashSettlementPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementPaymentDate")
		@Override
		public CashSettlement.CashSettlementBuilder setCashSettlementPaymentDate(CashSettlementPaymentDate _cashSettlementPaymentDate) {
			this.cashSettlementPaymentDate = _cashSettlementPaymentDate == null ? null : _cashSettlementPaymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("midMarketValuation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("midMarketValuation")
		@Override
		public CashSettlement.CashSettlementBuilder setMidMarketValuation(MidMarketValuation _midMarketValuation) {
			this.midMarketValuation = _midMarketValuation == null ? null : _midMarketValuation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("replacementValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("replacementValue")
		@Override
		public CashSettlement.CashSettlementBuilder setReplacementValue(ReplacementValue _replacementValue) {
			this.replacementValue = _replacementValue == null ? null : _replacementValue.toBuilder();
			return this;
		}
		
		@RosettaAttribute("parYieldCurveUnadjustedMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parYieldCurveUnadjustedMethod")
		@Override
		public CashSettlement.CashSettlementBuilder setParYieldCurveUnadjustedMethod(YieldCurveMethod _parYieldCurveUnadjustedMethod) {
			this.parYieldCurveUnadjustedMethod = _parYieldCurveUnadjustedMethod == null ? null : _parYieldCurveUnadjustedMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralizedCashPriceMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralizedCashPriceMethod")
		@Override
		public CashSettlement.CashSettlementBuilder setCollateralizedCashPriceMethod(CollateralizedCashPriceMethod _collateralizedCashPriceMethod) {
			this.collateralizedCashPriceMethod = _collateralizedCashPriceMethod == null ? null : _collateralizedCashPriceMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPriceMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPriceMethod")
		@Override
		public CashSettlement.CashSettlementBuilder setCashPriceMethod(CashPriceMethod _cashPriceMethod) {
			this.cashPriceMethod = _cashPriceMethod == null ? null : _cashPriceMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPriceAlternateMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPriceAlternateMethod")
		@Override
		public CashSettlement.CashSettlementBuilder setCashPriceAlternateMethod(CashPriceMethod _cashPriceAlternateMethod) {
			this.cashPriceAlternateMethod = _cashPriceAlternateMethod == null ? null : _cashPriceAlternateMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("parYieldCurveAdjustedMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parYieldCurveAdjustedMethod")
		@Override
		public CashSettlement.CashSettlementBuilder setParYieldCurveAdjustedMethod(YieldCurveMethod _parYieldCurveAdjustedMethod) {
			this.parYieldCurveAdjustedMethod = _parYieldCurveAdjustedMethod == null ? null : _parYieldCurveAdjustedMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("zeroCouponYieldAdjustedMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("zeroCouponYieldAdjustedMethod")
		@Override
		public CashSettlement.CashSettlementBuilder setZeroCouponYieldAdjustedMethod(YieldCurveMethod _zeroCouponYieldAdjustedMethod) {
			this.zeroCouponYieldAdjustedMethod = _zeroCouponYieldAdjustedMethod == null ? null : _zeroCouponYieldAdjustedMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("crossCurrencyMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("crossCurrencyMethod")
		@Override
		public CashSettlement.CashSettlementBuilder setCrossCurrencyMethod(CrossCurrencyMethod _crossCurrencyMethod) {
			this.crossCurrencyMethod = _crossCurrencyMethod == null ? null : _crossCurrencyMethod.toBuilder();
			return this;
		}
		
		@Override
		public CashSettlement build() {
			return new CashSettlement.CashSettlementImpl(this);
		}
		
		@Override
		public CashSettlement.CashSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlement.CashSettlementBuilder prune() {
			if (cashSettlementValuationTime!=null && !cashSettlementValuationTime.prune().hasData()) cashSettlementValuationTime = null;
			if (cashSettlementValuationDate!=null && !cashSettlementValuationDate.prune().hasData()) cashSettlementValuationDate = null;
			if (cashSettlementPaymentDate!=null && !cashSettlementPaymentDate.prune().hasData()) cashSettlementPaymentDate = null;
			if (midMarketValuation!=null && !midMarketValuation.prune().hasData()) midMarketValuation = null;
			if (replacementValue!=null && !replacementValue.prune().hasData()) replacementValue = null;
			if (parYieldCurveUnadjustedMethod!=null && !parYieldCurveUnadjustedMethod.prune().hasData()) parYieldCurveUnadjustedMethod = null;
			if (collateralizedCashPriceMethod!=null && !collateralizedCashPriceMethod.prune().hasData()) collateralizedCashPriceMethod = null;
			if (cashPriceMethod!=null && !cashPriceMethod.prune().hasData()) cashPriceMethod = null;
			if (cashPriceAlternateMethod!=null && !cashPriceAlternateMethod.prune().hasData()) cashPriceAlternateMethod = null;
			if (parYieldCurveAdjustedMethod!=null && !parYieldCurveAdjustedMethod.prune().hasData()) parYieldCurveAdjustedMethod = null;
			if (zeroCouponYieldAdjustedMethod!=null && !zeroCouponYieldAdjustedMethod.prune().hasData()) zeroCouponYieldAdjustedMethod = null;
			if (crossCurrencyMethod!=null && !crossCurrencyMethod.prune().hasData()) crossCurrencyMethod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getCashSettlementValuationTime()!=null && getCashSettlementValuationTime().hasData()) return true;
			if (getCashSettlementValuationDate()!=null && getCashSettlementValuationDate().hasData()) return true;
			if (getCashSettlementPaymentDate()!=null && getCashSettlementPaymentDate().hasData()) return true;
			if (getMidMarketValuation()!=null && getMidMarketValuation().hasData()) return true;
			if (getReplacementValue()!=null && getReplacementValue().hasData()) return true;
			if (getParYieldCurveUnadjustedMethod()!=null && getParYieldCurveUnadjustedMethod().hasData()) return true;
			if (getCollateralizedCashPriceMethod()!=null && getCollateralizedCashPriceMethod().hasData()) return true;
			if (getCashPriceMethod()!=null && getCashPriceMethod().hasData()) return true;
			if (getCashPriceAlternateMethod()!=null && getCashPriceAlternateMethod().hasData()) return true;
			if (getParYieldCurveAdjustedMethod()!=null && getParYieldCurveAdjustedMethod().hasData()) return true;
			if (getZeroCouponYieldAdjustedMethod()!=null && getZeroCouponYieldAdjustedMethod().hasData()) return true;
			if (getCrossCurrencyMethod()!=null && getCrossCurrencyMethod().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlement.CashSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashSettlement.CashSettlementBuilder o = (CashSettlement.CashSettlementBuilder) other;
			
			merger.mergeRosetta(getCashSettlementValuationTime(), o.getCashSettlementValuationTime(), this::setCashSettlementValuationTime);
			merger.mergeRosetta(getCashSettlementValuationDate(), o.getCashSettlementValuationDate(), this::setCashSettlementValuationDate);
			merger.mergeRosetta(getCashSettlementPaymentDate(), o.getCashSettlementPaymentDate(), this::setCashSettlementPaymentDate);
			merger.mergeRosetta(getMidMarketValuation(), o.getMidMarketValuation(), this::setMidMarketValuation);
			merger.mergeRosetta(getReplacementValue(), o.getReplacementValue(), this::setReplacementValue);
			merger.mergeRosetta(getParYieldCurveUnadjustedMethod(), o.getParYieldCurveUnadjustedMethod(), this::setParYieldCurveUnadjustedMethod);
			merger.mergeRosetta(getCollateralizedCashPriceMethod(), o.getCollateralizedCashPriceMethod(), this::setCollateralizedCashPriceMethod);
			merger.mergeRosetta(getCashPriceMethod(), o.getCashPriceMethod(), this::setCashPriceMethod);
			merger.mergeRosetta(getCashPriceAlternateMethod(), o.getCashPriceAlternateMethod(), this::setCashPriceAlternateMethod);
			merger.mergeRosetta(getParYieldCurveAdjustedMethod(), o.getParYieldCurveAdjustedMethod(), this::setParYieldCurveAdjustedMethod);
			merger.mergeRosetta(getZeroCouponYieldAdjustedMethod(), o.getZeroCouponYieldAdjustedMethod(), this::setZeroCouponYieldAdjustedMethod);
			merger.mergeRosetta(getCrossCurrencyMethod(), o.getCrossCurrencyMethod(), this::setCrossCurrencyMethod);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlement _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(cashSettlementValuationTime, _that.getCashSettlementValuationTime())) return false;
			if (!Objects.equals(cashSettlementValuationDate, _that.getCashSettlementValuationDate())) return false;
			if (!Objects.equals(cashSettlementPaymentDate, _that.getCashSettlementPaymentDate())) return false;
			if (!Objects.equals(midMarketValuation, _that.getMidMarketValuation())) return false;
			if (!Objects.equals(replacementValue, _that.getReplacementValue())) return false;
			if (!Objects.equals(parYieldCurveUnadjustedMethod, _that.getParYieldCurveUnadjustedMethod())) return false;
			if (!Objects.equals(collateralizedCashPriceMethod, _that.getCollateralizedCashPriceMethod())) return false;
			if (!Objects.equals(cashPriceMethod, _that.getCashPriceMethod())) return false;
			if (!Objects.equals(cashPriceAlternateMethod, _that.getCashPriceAlternateMethod())) return false;
			if (!Objects.equals(parYieldCurveAdjustedMethod, _that.getParYieldCurveAdjustedMethod())) return false;
			if (!Objects.equals(zeroCouponYieldAdjustedMethod, _that.getZeroCouponYieldAdjustedMethod())) return false;
			if (!Objects.equals(crossCurrencyMethod, _that.getCrossCurrencyMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (cashSettlementValuationTime != null ? cashSettlementValuationTime.hashCode() : 0);
			_result = 31 * _result + (cashSettlementValuationDate != null ? cashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (cashSettlementPaymentDate != null ? cashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (midMarketValuation != null ? midMarketValuation.hashCode() : 0);
			_result = 31 * _result + (replacementValue != null ? replacementValue.hashCode() : 0);
			_result = 31 * _result + (parYieldCurveUnadjustedMethod != null ? parYieldCurveUnadjustedMethod.hashCode() : 0);
			_result = 31 * _result + (collateralizedCashPriceMethod != null ? collateralizedCashPriceMethod.hashCode() : 0);
			_result = 31 * _result + (cashPriceMethod != null ? cashPriceMethod.hashCode() : 0);
			_result = 31 * _result + (cashPriceAlternateMethod != null ? cashPriceAlternateMethod.hashCode() : 0);
			_result = 31 * _result + (parYieldCurveAdjustedMethod != null ? parYieldCurveAdjustedMethod.hashCode() : 0);
			_result = 31 * _result + (zeroCouponYieldAdjustedMethod != null ? zeroCouponYieldAdjustedMethod.hashCode() : 0);
			_result = 31 * _result + (crossCurrencyMethod != null ? crossCurrencyMethod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementBuilder {" +
				"id=" + this.id + ", " +
				"cashSettlementValuationTime=" + this.cashSettlementValuationTime + ", " +
				"cashSettlementValuationDate=" + this.cashSettlementValuationDate + ", " +
				"cashSettlementPaymentDate=" + this.cashSettlementPaymentDate + ", " +
				"midMarketValuation=" + this.midMarketValuation + ", " +
				"replacementValue=" + this.replacementValue + ", " +
				"parYieldCurveUnadjustedMethod=" + this.parYieldCurveUnadjustedMethod + ", " +
				"collateralizedCashPriceMethod=" + this.collateralizedCashPriceMethod + ", " +
				"cashPriceMethod=" + this.cashPriceMethod + ", " +
				"cashPriceAlternateMethod=" + this.cashPriceAlternateMethod + ", " +
				"parYieldCurveAdjustedMethod=" + this.parYieldCurveAdjustedMethod + ", " +
				"zeroCouponYieldAdjustedMethod=" + this.zeroCouponYieldAdjustedMethod + ", " +
				"crossCurrencyMethod=" + this.crossCurrencyMethod +
			'}';
		}
	}
}
