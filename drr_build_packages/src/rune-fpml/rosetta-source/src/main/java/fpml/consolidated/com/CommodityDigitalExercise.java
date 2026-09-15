package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityDigitalExerciseMeta;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The parameters for defining how the commodity digital option can be exercised. It differs from the CommodityExercise type in that it lacks a specification of Settlement Currency. The Settlement Currency is specified in the 'featurePayment' element.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The parameters for defining how the commodity digital option can be exercised. It differs from the CommodityExercise type in that it lacks a specification of Settlement Currency. The Settlement Currency is specified in the 'featurePayment' element.
 *
 */
@RosettaDataType(value="CommodityDigitalExercise", builder=CommodityDigitalExercise.CommodityDigitalExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityDigitalExercise", model="fpml", builder=CommodityDigitalExercise.CommodityDigitalExerciseBuilderImpl.class, version="2.1.1")
public interface CommodityDigitalExercise extends RosettaModelObject {

	CommodityDigitalExerciseMeta metaData = new CommodityDigitalExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining the expiration date for an American option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining the expiration date for an American option.
	 *
	 */
	CommodityAmericanExercise getAmericanExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining the expiration date and time for a European or Asian style option. For an Asian style option the expiration date is equivalent to the termination date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining the expiration date and time for a European or Asian style option. For an Asian style option the expiration date is equivalent to the termination date.
	 *
	 */
	CommodityEuropeanExercise getEuropeanExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether or not Automatic Exercise applies to a Commodity Option Transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether or not Automatic Exercise applies to a Commodity Option Transaction.
	 *
	 */
	Boolean getAutomaticExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether or not Written Confirmation applies to a Commodity Option Transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether or not Written Confirmation applies to a Commodity Option Transaction.
	 *
	 */
	Boolean getWrittenConfirmation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Payment Dates of the trade relative to the Calculation Periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Payment Dates of the trade relative to the Calculation Periods.
	 *
	 */
	CommodityRelativePaymentDates getRelativePaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Dates on which payments will be made.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Dates on which payments will be made.
	 *
	 */
	AdjustableDatesOrRelativeDateOffset getPaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and true indicates that the Payment Date(s) are specified in the relevant master agreement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and true indicates that the Payment Date(s) are specified in the relevant master agreement.
	 *
	 */
	Boolean getMasterAgreementPaymentDates();

	/*********************** Build Methods  ***********************/
	CommodityDigitalExercise build();
	
	CommodityDigitalExercise.CommodityDigitalExerciseBuilder toBuilder();
	
	static CommodityDigitalExercise.CommodityDigitalExerciseBuilder builder() {
		return new CommodityDigitalExercise.CommodityDigitalExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDigitalExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityDigitalExercise> getType() {
		return CommodityDigitalExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("americanExercise"), processor, CommodityAmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("europeanExercise"), processor, CommodityEuropeanExercise.class, getEuropeanExercise());
		processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
		processor.processBasic(path.newSubPath("writtenConfirmation"), Boolean.class, getWrittenConfirmation(), this);
		processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.class, getRelativePaymentDates());
		processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.class, getPaymentDates());
		processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDigitalExerciseBuilder extends CommodityDigitalExercise, RosettaModelObjectBuilder {
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder getOrCreateAmericanExercise();
		@Override
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder getAmericanExercise();
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getOrCreateEuropeanExercise();
		@Override
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getEuropeanExercise();
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreateRelativePaymentDates();
		@Override
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getRelativePaymentDates();
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreatePaymentDates();
		@Override
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getPaymentDates();
		CommodityDigitalExercise.CommodityDigitalExerciseBuilder setAmericanExercise(CommodityAmericanExercise americanExercise);
		CommodityDigitalExercise.CommodityDigitalExerciseBuilder setEuropeanExercise(CommodityEuropeanExercise europeanExercise);
		CommodityDigitalExercise.CommodityDigitalExerciseBuilder setAutomaticExercise(Boolean automaticExercise);
		CommodityDigitalExercise.CommodityDigitalExerciseBuilder setWrittenConfirmation(Boolean writtenConfirmation);
		CommodityDigitalExercise.CommodityDigitalExerciseBuilder setRelativePaymentDates(CommodityRelativePaymentDates relativePaymentDates);
		CommodityDigitalExercise.CommodityDigitalExerciseBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset paymentDates);
		CommodityDigitalExercise.CommodityDigitalExerciseBuilder setMasterAgreementPaymentDates(Boolean masterAgreementPaymentDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("americanExercise"), processor, CommodityAmericanExercise.CommodityAmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("europeanExercise"), processor, CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder.class, getEuropeanExercise());
			processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
			processor.processBasic(path.newSubPath("writtenConfirmation"), Boolean.class, getWrittenConfirmation(), this);
			processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder.class, getRelativePaymentDates());
			processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder.class, getPaymentDates());
			processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
		}
		

		CommodityDigitalExercise.CommodityDigitalExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDigitalExercise  ***********************/
	class CommodityDigitalExerciseImpl implements CommodityDigitalExercise {
		private final CommodityAmericanExercise americanExercise;
		private final CommodityEuropeanExercise europeanExercise;
		private final Boolean automaticExercise;
		private final Boolean writtenConfirmation;
		private final CommodityRelativePaymentDates relativePaymentDates;
		private final AdjustableDatesOrRelativeDateOffset paymentDates;
		private final Boolean masterAgreementPaymentDates;
		
		protected CommodityDigitalExerciseImpl(CommodityDigitalExercise.CommodityDigitalExerciseBuilder builder) {
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.automaticExercise = builder.getAutomaticExercise();
			this.writtenConfirmation = builder.getWrittenConfirmation();
			this.relativePaymentDates = ofNullable(builder.getRelativePaymentDates()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.masterAgreementPaymentDates = builder.getMasterAgreementPaymentDates();
		}
		
		@Override
		@RosettaAttribute("americanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("americanExercise")
		public CommodityAmericanExercise getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("europeanExercise")
		public CommodityEuropeanExercise getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("automaticExercise")
		public Boolean getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		@RosettaAttribute("writtenConfirmation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("writtenConfirmation")
		public Boolean getWrittenConfirmation() {
			return writtenConfirmation;
		}
		
		@Override
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativePaymentDates")
		public CommodityRelativePaymentDates getRelativePaymentDates() {
			return relativePaymentDates;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public AdjustableDatesOrRelativeDateOffset getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		public Boolean getMasterAgreementPaymentDates() {
			return masterAgreementPaymentDates;
		}
		
		@Override
		public CommodityDigitalExercise build() {
			return this;
		}
		
		@Override
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder toBuilder() {
			CommodityDigitalExercise.CommodityDigitalExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDigitalExercise.CommodityDigitalExerciseBuilder builder) {
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getAutomaticExercise()).ifPresent(builder::setAutomaticExercise);
			ofNullable(getWrittenConfirmation()).ifPresent(builder::setWrittenConfirmation);
			ofNullable(getRelativePaymentDates()).ifPresent(builder::setRelativePaymentDates);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getMasterAgreementPaymentDates()).ifPresent(builder::setMasterAgreementPaymentDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDigitalExercise _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(writtenConfirmation, _that.getWrittenConfirmation())) return false;
			if (!Objects.equals(relativePaymentDates, _that.getRelativePaymentDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(masterAgreementPaymentDates, _that.getMasterAgreementPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (writtenConfirmation != null ? writtenConfirmation.hashCode() : 0);
			_result = 31 * _result + (relativePaymentDates != null ? relativePaymentDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (masterAgreementPaymentDates != null ? masterAgreementPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigitalExercise {" +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"automaticExercise=" + this.automaticExercise + ", " +
				"writtenConfirmation=" + this.writtenConfirmation + ", " +
				"relativePaymentDates=" + this.relativePaymentDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"masterAgreementPaymentDates=" + this.masterAgreementPaymentDates +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityDigitalExercise  ***********************/
	class CommodityDigitalExerciseBuilderImpl implements CommodityDigitalExercise.CommodityDigitalExerciseBuilder {
	
		protected CommodityAmericanExercise.CommodityAmericanExerciseBuilder americanExercise;
		protected CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder europeanExercise;
		protected Boolean automaticExercise;
		protected Boolean writtenConfirmation;
		protected CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder relativePaymentDates;
		protected AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder paymentDates;
		protected Boolean masterAgreementPaymentDates;
		
		@Override
		@RosettaAttribute("americanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("americanExercise")
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder getOrCreateAmericanExercise() {
			CommodityAmericanExercise.CommodityAmericanExerciseBuilder result;
			if (americanExercise!=null) {
				result = americanExercise;
			}
			else {
				result = americanExercise = CommodityAmericanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("europeanExercise")
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder getOrCreateEuropeanExercise() {
			CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder result;
			if (europeanExercise!=null) {
				result = europeanExercise;
			}
			else {
				result = europeanExercise = CommodityEuropeanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("automaticExercise")
		public Boolean getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		@RosettaAttribute("writtenConfirmation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("writtenConfirmation")
		public Boolean getWrittenConfirmation() {
			return writtenConfirmation;
		}
		
		@Override
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativePaymentDates")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getRelativePaymentDates() {
			return relativePaymentDates;
		}
		
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreateRelativePaymentDates() {
			CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder result;
			if (relativePaymentDates!=null) {
				result = relativePaymentDates;
			}
			else {
				result = relativePaymentDates = CommodityRelativePaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreatePaymentDates() {
			AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = AdjustableDatesOrRelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		public Boolean getMasterAgreementPaymentDates() {
			return masterAgreementPaymentDates;
		}
		
		@RosettaAttribute("americanExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("americanExercise")
		@Override
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder setAmericanExercise(CommodityAmericanExercise _americanExercise) {
			this.americanExercise = _americanExercise == null ? null : _americanExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("europeanExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("europeanExercise")
		@Override
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder setEuropeanExercise(CommodityEuropeanExercise _europeanExercise) {
			this.europeanExercise = _europeanExercise == null ? null : _europeanExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("automaticExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("automaticExercise")
		@Override
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder setAutomaticExercise(Boolean _automaticExercise) {
			this.automaticExercise = _automaticExercise == null ? null : _automaticExercise;
			return this;
		}
		
		@RosettaAttribute("writtenConfirmation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("writtenConfirmation")
		@Override
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder setWrittenConfirmation(Boolean _writtenConfirmation) {
			this.writtenConfirmation = _writtenConfirmation == null ? null : _writtenConfirmation;
			return this;
		}
		
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativePaymentDates")
		@Override
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder setRelativePaymentDates(CommodityRelativePaymentDates _relativePaymentDates) {
			this.relativePaymentDates = _relativePaymentDates == null ? null : _relativePaymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDates")
		@Override
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset _paymentDates) {
			this.paymentDates = _paymentDates == null ? null : _paymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		@Override
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder setMasterAgreementPaymentDates(Boolean _masterAgreementPaymentDates) {
			this.masterAgreementPaymentDates = _masterAgreementPaymentDates == null ? null : _masterAgreementPaymentDates;
			return this;
		}
		
		@Override
		public CommodityDigitalExercise build() {
			return new CommodityDigitalExercise.CommodityDigitalExerciseImpl(this);
		}
		
		@Override
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder prune() {
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			if (relativePaymentDates!=null && !relativePaymentDates.prune().hasData()) relativePaymentDates = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmericanExercise()!=null && getAmericanExercise().hasData()) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getAutomaticExercise()!=null) return true;
			if (getWrittenConfirmation()!=null) return true;
			if (getRelativePaymentDates()!=null && getRelativePaymentDates().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getMasterAgreementPaymentDates()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityDigitalExercise.CommodityDigitalExerciseBuilder o = (CommodityDigitalExercise.CommodityDigitalExerciseBuilder) other;
			
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getRelativePaymentDates(), o.getRelativePaymentDates(), this::setRelativePaymentDates);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			
			merger.mergeBasic(getAutomaticExercise(), o.getAutomaticExercise(), this::setAutomaticExercise);
			merger.mergeBasic(getWrittenConfirmation(), o.getWrittenConfirmation(), this::setWrittenConfirmation);
			merger.mergeBasic(getMasterAgreementPaymentDates(), o.getMasterAgreementPaymentDates(), this::setMasterAgreementPaymentDates);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDigitalExercise _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(writtenConfirmation, _that.getWrittenConfirmation())) return false;
			if (!Objects.equals(relativePaymentDates, _that.getRelativePaymentDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(masterAgreementPaymentDates, _that.getMasterAgreementPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (writtenConfirmation != null ? writtenConfirmation.hashCode() : 0);
			_result = 31 * _result + (relativePaymentDates != null ? relativePaymentDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (masterAgreementPaymentDates != null ? masterAgreementPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigitalExerciseBuilder {" +
				"americanExercise=" + this.americanExercise + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"automaticExercise=" + this.automaticExercise + ", " +
				"writtenConfirmation=" + this.writtenConfirmation + ", " +
				"relativePaymentDates=" + this.relativePaymentDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"masterAgreementPaymentDates=" + this.masterAgreementPaymentDates +
			'}';
		}
	}
}
