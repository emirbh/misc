package fpml.consolidated.shared;

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
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.shared.meta.SwaptionPhysicalSettlementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="SwaptionPhysicalSettlement", builder=SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SwaptionPhysicalSettlement", model="fpml", builder=SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilderImpl.class, version="2.1.1")
public interface SwaptionPhysicalSettlement extends RosettaModelObject {

	SwaptionPhysicalSettlementMeta metaData = new SwaptionPhysicalSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the swap resulting from physical settlement of the swaption transaction will clear through a clearing house. The meaning of Cleared Physical Settlement is defined in the 2006 ISDA Definitions, Section 15.2 (published in Supplement number 28).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the swap resulting from physical settlement of the swaption transaction will clear through a clearing house. The meaning of Cleared Physical Settlement is defined in the 2006 ISDA Definitions, Section 15.2 (published in Supplement number 28).
	 *
	 */
	Boolean getClearedPhysicalSettlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the clearing organization (CCP, DCO) to which the trade should be cleared. This is also known as the "Mutually Agreed Clearinghouse".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the clearing organization (CCP, DCO) to which the trade should be cleared. This is also known as the "Mutually Agreed Clearinghouse".
	 *
	 */
	PartyReference getPredeterminedClearingOrganizationPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to specify a "mutually-agreed clearinghouse" for settlement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to specify a "mutually-agreed clearinghouse" for settlement.
	 *
	 */
	MutuallyAgreedClearinghouse getMutuallyAgreedClearinghouse();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to indicate the discount rate to be used for cash collateral for cash settlement purposes.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to indicate the discount rate to be used for cash collateral for cash settlement purposes.
	 *
	 */
	BenchmarkRate getAgreedDiscountRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The method for obtaining a settlement rate. This may be from some information source (e.g. Reuters) or from a set of reference banks.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The method for obtaining a settlement rate. This may be from some information source (e.g. Reuters) or from a set of reference banks.
	 *
	 */
	SettlementRateSource getSettlementRateSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Which rate quote is to be observed, either Bid, Mid, Offer or Exercising Party Pays. The meaning of Exercising Party Pays is defined in the 2000 ISDA Definitions, Section 17.2. Certain Definitions Relating to Cash Settlement, paragraph (j)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Which rate quote is to be observed, either Bid, Mid, Offer or Exercising Party Pays. The meaning of Exercising Party Pays is defined in the 2000 ISDA Definitions, Section 17.2. Certain Definitions Relating to Cash Settlement, paragraph (j)
	 *
	 */
	QuotationRateTypeEnum getQuotationRateType();

	/*********************** Build Methods  ***********************/
	SwaptionPhysicalSettlement build();
	
	SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder toBuilder();
	
	static SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder builder() {
		return new SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SwaptionPhysicalSettlement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SwaptionPhysicalSettlement> getType() {
		return SwaptionPhysicalSettlement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("clearedPhysicalSettlement"), Boolean.class, getClearedPhysicalSettlement(), this);
		processRosetta(path.newSubPath("predeterminedClearingOrganizationPartyReference"), processor, PartyReference.class, getPredeterminedClearingOrganizationPartyReference());
		processRosetta(path.newSubPath("mutuallyAgreedClearinghouse"), processor, MutuallyAgreedClearinghouse.class, getMutuallyAgreedClearinghouse());
		processRosetta(path.newSubPath("agreedDiscountRate"), processor, BenchmarkRate.class, getAgreedDiscountRate());
		processRosetta(path.newSubPath("settlementRateSource"), processor, SettlementRateSource.class, getSettlementRateSource());
		processor.processBasic(path.newSubPath("quotationRateType"), QuotationRateTypeEnum.class, getQuotationRateType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SwaptionPhysicalSettlementBuilder extends SwaptionPhysicalSettlement, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePredeterminedClearingOrganizationPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPredeterminedClearingOrganizationPartyReference();
		MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder getOrCreateMutuallyAgreedClearinghouse();
		@Override
		MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder getMutuallyAgreedClearinghouse();
		BenchmarkRate.BenchmarkRateBuilder getOrCreateAgreedDiscountRate();
		@Override
		BenchmarkRate.BenchmarkRateBuilder getAgreedDiscountRate();
		SettlementRateSource.SettlementRateSourceBuilder getOrCreateSettlementRateSource();
		@Override
		SettlementRateSource.SettlementRateSourceBuilder getSettlementRateSource();
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setClearedPhysicalSettlement(Boolean clearedPhysicalSettlement);
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setPredeterminedClearingOrganizationPartyReference(PartyReference predeterminedClearingOrganizationPartyReference);
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setMutuallyAgreedClearinghouse(MutuallyAgreedClearinghouse mutuallyAgreedClearinghouse);
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setAgreedDiscountRate(BenchmarkRate agreedDiscountRate);
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setSettlementRateSource(SettlementRateSource settlementRateSource);
		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setQuotationRateType(QuotationRateTypeEnum quotationRateType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("clearedPhysicalSettlement"), Boolean.class, getClearedPhysicalSettlement(), this);
			processRosetta(path.newSubPath("predeterminedClearingOrganizationPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPredeterminedClearingOrganizationPartyReference());
			processRosetta(path.newSubPath("mutuallyAgreedClearinghouse"), processor, MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder.class, getMutuallyAgreedClearinghouse());
			processRosetta(path.newSubPath("agreedDiscountRate"), processor, BenchmarkRate.BenchmarkRateBuilder.class, getAgreedDiscountRate());
			processRosetta(path.newSubPath("settlementRateSource"), processor, SettlementRateSource.SettlementRateSourceBuilder.class, getSettlementRateSource());
			processor.processBasic(path.newSubPath("quotationRateType"), QuotationRateTypeEnum.class, getQuotationRateType(), this);
		}
		

		SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of SwaptionPhysicalSettlement  ***********************/
	class SwaptionPhysicalSettlementImpl implements SwaptionPhysicalSettlement {
		private final Boolean clearedPhysicalSettlement;
		private final PartyReference predeterminedClearingOrganizationPartyReference;
		private final MutuallyAgreedClearinghouse mutuallyAgreedClearinghouse;
		private final BenchmarkRate agreedDiscountRate;
		private final SettlementRateSource settlementRateSource;
		private final QuotationRateTypeEnum quotationRateType;
		
		protected SwaptionPhysicalSettlementImpl(SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder builder) {
			this.clearedPhysicalSettlement = builder.getClearedPhysicalSettlement();
			this.predeterminedClearingOrganizationPartyReference = ofNullable(builder.getPredeterminedClearingOrganizationPartyReference()).map(f->f.build()).orElse(null);
			this.mutuallyAgreedClearinghouse = ofNullable(builder.getMutuallyAgreedClearinghouse()).map(f->f.build()).orElse(null);
			this.agreedDiscountRate = ofNullable(builder.getAgreedDiscountRate()).map(f->f.build()).orElse(null);
			this.settlementRateSource = ofNullable(builder.getSettlementRateSource()).map(f->f.build()).orElse(null);
			this.quotationRateType = builder.getQuotationRateType();
		}
		
		@Override
		@RosettaAttribute("clearedPhysicalSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearedPhysicalSettlement")
		public Boolean getClearedPhysicalSettlement() {
			return clearedPhysicalSettlement;
		}
		
		@Override
		@RosettaAttribute("predeterminedClearingOrganizationPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("predeterminedClearingOrganizationPartyReference")
		public PartyReference getPredeterminedClearingOrganizationPartyReference() {
			return predeterminedClearingOrganizationPartyReference;
		}
		
		@Override
		@RosettaAttribute("mutuallyAgreedClearinghouse")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mutuallyAgreedClearinghouse")
		public MutuallyAgreedClearinghouse getMutuallyAgreedClearinghouse() {
			return mutuallyAgreedClearinghouse;
		}
		
		@Override
		@RosettaAttribute("agreedDiscountRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreedDiscountRate")
		public BenchmarkRate getAgreedDiscountRate() {
			return agreedDiscountRate;
		}
		
		@Override
		@RosettaAttribute("settlementRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementRateSource")
		public SettlementRateSource getSettlementRateSource() {
			return settlementRateSource;
		}
		
		@Override
		@RosettaAttribute("quotationRateType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotationRateType")
		public QuotationRateTypeEnum getQuotationRateType() {
			return quotationRateType;
		}
		
		@Override
		public SwaptionPhysicalSettlement build() {
			return this;
		}
		
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder toBuilder() {
			SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder builder) {
			ofNullable(getClearedPhysicalSettlement()).ifPresent(builder::setClearedPhysicalSettlement);
			ofNullable(getPredeterminedClearingOrganizationPartyReference()).ifPresent(builder::setPredeterminedClearingOrganizationPartyReference);
			ofNullable(getMutuallyAgreedClearinghouse()).ifPresent(builder::setMutuallyAgreedClearinghouse);
			ofNullable(getAgreedDiscountRate()).ifPresent(builder::setAgreedDiscountRate);
			ofNullable(getSettlementRateSource()).ifPresent(builder::setSettlementRateSource);
			ofNullable(getQuotationRateType()).ifPresent(builder::setQuotationRateType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwaptionPhysicalSettlement _that = getType().cast(o);
		
			if (!Objects.equals(clearedPhysicalSettlement, _that.getClearedPhysicalSettlement())) return false;
			if (!Objects.equals(predeterminedClearingOrganizationPartyReference, _that.getPredeterminedClearingOrganizationPartyReference())) return false;
			if (!Objects.equals(mutuallyAgreedClearinghouse, _that.getMutuallyAgreedClearinghouse())) return false;
			if (!Objects.equals(agreedDiscountRate, _that.getAgreedDiscountRate())) return false;
			if (!Objects.equals(settlementRateSource, _that.getSettlementRateSource())) return false;
			if (!Objects.equals(quotationRateType, _that.getQuotationRateType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clearedPhysicalSettlement != null ? clearedPhysicalSettlement.hashCode() : 0);
			_result = 31 * _result + (predeterminedClearingOrganizationPartyReference != null ? predeterminedClearingOrganizationPartyReference.hashCode() : 0);
			_result = 31 * _result + (mutuallyAgreedClearinghouse != null ? mutuallyAgreedClearinghouse.hashCode() : 0);
			_result = 31 * _result + (agreedDiscountRate != null ? agreedDiscountRate.hashCode() : 0);
			_result = 31 * _result + (settlementRateSource != null ? settlementRateSource.hashCode() : 0);
			_result = 31 * _result + (quotationRateType != null ? quotationRateType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwaptionPhysicalSettlement {" +
				"clearedPhysicalSettlement=" + this.clearedPhysicalSettlement + ", " +
				"predeterminedClearingOrganizationPartyReference=" + this.predeterminedClearingOrganizationPartyReference + ", " +
				"mutuallyAgreedClearinghouse=" + this.mutuallyAgreedClearinghouse + ", " +
				"agreedDiscountRate=" + this.agreedDiscountRate + ", " +
				"settlementRateSource=" + this.settlementRateSource + ", " +
				"quotationRateType=" + this.quotationRateType +
			'}';
		}
	}

	/*********************** Builder Implementation of SwaptionPhysicalSettlement  ***********************/
	class SwaptionPhysicalSettlementBuilderImpl implements SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder {
	
		protected Boolean clearedPhysicalSettlement;
		protected PartyReference.PartyReferenceBuilder predeterminedClearingOrganizationPartyReference;
		protected MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder mutuallyAgreedClearinghouse;
		protected BenchmarkRate.BenchmarkRateBuilder agreedDiscountRate;
		protected SettlementRateSource.SettlementRateSourceBuilder settlementRateSource;
		protected QuotationRateTypeEnum quotationRateType;
		
		@Override
		@RosettaAttribute("clearedPhysicalSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearedPhysicalSettlement")
		public Boolean getClearedPhysicalSettlement() {
			return clearedPhysicalSettlement;
		}
		
		@Override
		@RosettaAttribute("predeterminedClearingOrganizationPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("predeterminedClearingOrganizationPartyReference")
		public PartyReference.PartyReferenceBuilder getPredeterminedClearingOrganizationPartyReference() {
			return predeterminedClearingOrganizationPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePredeterminedClearingOrganizationPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (predeterminedClearingOrganizationPartyReference!=null) {
				result = predeterminedClearingOrganizationPartyReference;
			}
			else {
				result = predeterminedClearingOrganizationPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mutuallyAgreedClearinghouse")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mutuallyAgreedClearinghouse")
		public MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder getMutuallyAgreedClearinghouse() {
			return mutuallyAgreedClearinghouse;
		}
		
		@Override
		public MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder getOrCreateMutuallyAgreedClearinghouse() {
			MutuallyAgreedClearinghouse.MutuallyAgreedClearinghouseBuilder result;
			if (mutuallyAgreedClearinghouse!=null) {
				result = mutuallyAgreedClearinghouse;
			}
			else {
				result = mutuallyAgreedClearinghouse = MutuallyAgreedClearinghouse.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("agreedDiscountRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreedDiscountRate")
		public BenchmarkRate.BenchmarkRateBuilder getAgreedDiscountRate() {
			return agreedDiscountRate;
		}
		
		@Override
		public BenchmarkRate.BenchmarkRateBuilder getOrCreateAgreedDiscountRate() {
			BenchmarkRate.BenchmarkRateBuilder result;
			if (agreedDiscountRate!=null) {
				result = agreedDiscountRate;
			}
			else {
				result = agreedDiscountRate = BenchmarkRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementRateSource")
		public SettlementRateSource.SettlementRateSourceBuilder getSettlementRateSource() {
			return settlementRateSource;
		}
		
		@Override
		public SettlementRateSource.SettlementRateSourceBuilder getOrCreateSettlementRateSource() {
			SettlementRateSource.SettlementRateSourceBuilder result;
			if (settlementRateSource!=null) {
				result = settlementRateSource;
			}
			else {
				result = settlementRateSource = SettlementRateSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotationRateType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotationRateType")
		public QuotationRateTypeEnum getQuotationRateType() {
			return quotationRateType;
		}
		
		@RosettaAttribute("clearedPhysicalSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearedPhysicalSettlement")
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setClearedPhysicalSettlement(Boolean _clearedPhysicalSettlement) {
			this.clearedPhysicalSettlement = _clearedPhysicalSettlement == null ? null : _clearedPhysicalSettlement;
			return this;
		}
		
		@RosettaAttribute("predeterminedClearingOrganizationPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("predeterminedClearingOrganizationPartyReference")
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setPredeterminedClearingOrganizationPartyReference(PartyReference _predeterminedClearingOrganizationPartyReference) {
			this.predeterminedClearingOrganizationPartyReference = _predeterminedClearingOrganizationPartyReference == null ? null : _predeterminedClearingOrganizationPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mutuallyAgreedClearinghouse")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mutuallyAgreedClearinghouse")
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setMutuallyAgreedClearinghouse(MutuallyAgreedClearinghouse _mutuallyAgreedClearinghouse) {
			this.mutuallyAgreedClearinghouse = _mutuallyAgreedClearinghouse == null ? null : _mutuallyAgreedClearinghouse.toBuilder();
			return this;
		}
		
		@RosettaAttribute("agreedDiscountRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreedDiscountRate")
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setAgreedDiscountRate(BenchmarkRate _agreedDiscountRate) {
			this.agreedDiscountRate = _agreedDiscountRate == null ? null : _agreedDiscountRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementRateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementRateSource")
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setSettlementRateSource(SettlementRateSource _settlementRateSource) {
			this.settlementRateSource = _settlementRateSource == null ? null : _settlementRateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quotationRateType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotationRateType")
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder setQuotationRateType(QuotationRateTypeEnum _quotationRateType) {
			this.quotationRateType = _quotationRateType == null ? null : _quotationRateType;
			return this;
		}
		
		@Override
		public SwaptionPhysicalSettlement build() {
			return new SwaptionPhysicalSettlement.SwaptionPhysicalSettlementImpl(this);
		}
		
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder prune() {
			if (predeterminedClearingOrganizationPartyReference!=null && !predeterminedClearingOrganizationPartyReference.prune().hasData()) predeterminedClearingOrganizationPartyReference = null;
			if (mutuallyAgreedClearinghouse!=null && !mutuallyAgreedClearinghouse.prune().hasData()) mutuallyAgreedClearinghouse = null;
			if (agreedDiscountRate!=null && !agreedDiscountRate.prune().hasData()) agreedDiscountRate = null;
			if (settlementRateSource!=null && !settlementRateSource.prune().hasData()) settlementRateSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getClearedPhysicalSettlement()!=null) return true;
			if (getPredeterminedClearingOrganizationPartyReference()!=null && getPredeterminedClearingOrganizationPartyReference().hasData()) return true;
			if (getMutuallyAgreedClearinghouse()!=null && getMutuallyAgreedClearinghouse().hasData()) return true;
			if (getAgreedDiscountRate()!=null && getAgreedDiscountRate().hasData()) return true;
			if (getSettlementRateSource()!=null && getSettlementRateSource().hasData()) return true;
			if (getQuotationRateType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder o = (SwaptionPhysicalSettlement.SwaptionPhysicalSettlementBuilder) other;
			
			merger.mergeRosetta(getPredeterminedClearingOrganizationPartyReference(), o.getPredeterminedClearingOrganizationPartyReference(), this::setPredeterminedClearingOrganizationPartyReference);
			merger.mergeRosetta(getMutuallyAgreedClearinghouse(), o.getMutuallyAgreedClearinghouse(), this::setMutuallyAgreedClearinghouse);
			merger.mergeRosetta(getAgreedDiscountRate(), o.getAgreedDiscountRate(), this::setAgreedDiscountRate);
			merger.mergeRosetta(getSettlementRateSource(), o.getSettlementRateSource(), this::setSettlementRateSource);
			
			merger.mergeBasic(getClearedPhysicalSettlement(), o.getClearedPhysicalSettlement(), this::setClearedPhysicalSettlement);
			merger.mergeBasic(getQuotationRateType(), o.getQuotationRateType(), this::setQuotationRateType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwaptionPhysicalSettlement _that = getType().cast(o);
		
			if (!Objects.equals(clearedPhysicalSettlement, _that.getClearedPhysicalSettlement())) return false;
			if (!Objects.equals(predeterminedClearingOrganizationPartyReference, _that.getPredeterminedClearingOrganizationPartyReference())) return false;
			if (!Objects.equals(mutuallyAgreedClearinghouse, _that.getMutuallyAgreedClearinghouse())) return false;
			if (!Objects.equals(agreedDiscountRate, _that.getAgreedDiscountRate())) return false;
			if (!Objects.equals(settlementRateSource, _that.getSettlementRateSource())) return false;
			if (!Objects.equals(quotationRateType, _that.getQuotationRateType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clearedPhysicalSettlement != null ? clearedPhysicalSettlement.hashCode() : 0);
			_result = 31 * _result + (predeterminedClearingOrganizationPartyReference != null ? predeterminedClearingOrganizationPartyReference.hashCode() : 0);
			_result = 31 * _result + (mutuallyAgreedClearinghouse != null ? mutuallyAgreedClearinghouse.hashCode() : 0);
			_result = 31 * _result + (agreedDiscountRate != null ? agreedDiscountRate.hashCode() : 0);
			_result = 31 * _result + (settlementRateSource != null ? settlementRateSource.hashCode() : 0);
			_result = 31 * _result + (quotationRateType != null ? quotationRateType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwaptionPhysicalSettlementBuilder {" +
				"clearedPhysicalSettlement=" + this.clearedPhysicalSettlement + ", " +
				"predeterminedClearingOrganizationPartyReference=" + this.predeterminedClearingOrganizationPartyReference + ", " +
				"mutuallyAgreedClearinghouse=" + this.mutuallyAgreedClearinghouse + ", " +
				"agreedDiscountRate=" + this.agreedDiscountRate + ", " +
				"settlementRateSource=" + this.settlementRateSource + ", " +
				"quotationRateType=" + this.quotationRateType +
			'}';
		}
	}
}
