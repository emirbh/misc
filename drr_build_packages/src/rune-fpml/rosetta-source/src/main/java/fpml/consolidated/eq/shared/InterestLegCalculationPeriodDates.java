package fpml.consolidated.eq.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.eq.shared.meta.InterestLegCalculationPeriodDatesMeta;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates2;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Component that holds the various dates used to specify the interest leg of the return swap. It is used to define the InterestPeriodDates identifyer.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Component that holds the various dates used to specify the interest leg of the return swap. It is used to define the InterestPeriodDates identifyer.
 *
 */
@RosettaDataType(value="InterestLegCalculationPeriodDates", builder=InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InterestLegCalculationPeriodDates", model="fpml", builder=InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilderImpl.class, version="2.1.1")
public interface InterestLegCalculationPeriodDates extends RosettaModelObject {

	InterestLegCalculationPeriodDatesMeta metaData = new InterestLegCalculationPeriodDatesMeta();

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
	 * Provision Specifies the effective date of the return swap. This global element is valid within the return swaps namespace. Within the FpML namespace, another effectiveDate global element has been defined, that is different in the sense that it does not propose the choice of refering to another date in the document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the effective date of the return swap. This global element is valid within the return swaps namespace. Within the FpML namespace, another effectiveDate global element has been defined, that is different in the sense that it does not propose the choice of refering to another date in the document.
	 *
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the termination date of the return swap. This global element is valid within the return swaps namespace. Within the FpML namespace, another terminationDate global element has been defined, that is different in the sense that it does not propose the choice of refering to another date in the document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the termination date of the return swap. This global element is valid within the return swaps namespace. Within the FpML namespace, another terminationDate global element has been defined, that is different in the sense that it does not propose the choice of refering to another date in the document.
	 *
	 */
	AdjustableOrRelativeDate getTerminationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the reset dates of the interest leg of the swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the reset dates of the interest leg of the swap.
	 *
	 */
	InterestLegResetDates getInterestLegResetDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the payment dates of the interest leg of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDates component), this element will typically point to the payment dates of the equity leg of the swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the payment dates of the interest leg of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDates component), this element will typically point to the payment dates of the equity leg of the swap.
	 *
	 */
	AdjustableRelativeOrPeriodicDates2 getInterestLegPaymentDates();

	/*********************** Build Methods  ***********************/
	InterestLegCalculationPeriodDates build();
	
	InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder toBuilder();
	
	static InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder builder() {
		return new InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestLegCalculationPeriodDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestLegCalculationPeriodDates> getType() {
		return InterestLegCalculationPeriodDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("interestLegResetDates"), processor, InterestLegResetDates.class, getInterestLegResetDates());
		processRosetta(path.newSubPath("interestLegPaymentDates"), processor, AdjustableRelativeOrPeriodicDates2.class, getInterestLegPaymentDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestLegCalculationPeriodDatesBuilder extends InterestLegCalculationPeriodDates, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate();
		InterestLegResetDates.InterestLegResetDatesBuilder getOrCreateInterestLegResetDates();
		@Override
		InterestLegResetDates.InterestLegResetDatesBuilder getInterestLegResetDates();
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getOrCreateInterestLegPaymentDates();
		@Override
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getInterestLegPaymentDates();
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setId(String id);
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setInterestLegResetDates(InterestLegResetDates interestLegResetDates);
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setInterestLegPaymentDates(AdjustableRelativeOrPeriodicDates2 interestLegPaymentDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("interestLegResetDates"), processor, InterestLegResetDates.InterestLegResetDatesBuilder.class, getInterestLegResetDates());
			processRosetta(path.newSubPath("interestLegPaymentDates"), processor, AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder.class, getInterestLegPaymentDates());
		}
		

		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder prune();
	}

	/*********************** Immutable Implementation of InterestLegCalculationPeriodDates  ***********************/
	class InterestLegCalculationPeriodDatesImpl implements InterestLegCalculationPeriodDates {
		private final String id;
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		private final InterestLegResetDates interestLegResetDates;
		private final AdjustableRelativeOrPeriodicDates2 interestLegPaymentDates;
		
		protected InterestLegCalculationPeriodDatesImpl(InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder builder) {
			this.id = builder.getId();
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.interestLegResetDates = ofNullable(builder.getInterestLegResetDates()).map(f->f.build()).orElse(null);
			this.interestLegPaymentDates = ofNullable(builder.getInterestLegPaymentDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminationDate")
		public AdjustableOrRelativeDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("interestLegResetDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestLegResetDates")
		public InterestLegResetDates getInterestLegResetDates() {
			return interestLegResetDates;
		}
		
		@Override
		@RosettaAttribute("interestLegPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestLegPaymentDates")
		public AdjustableRelativeOrPeriodicDates2 getInterestLegPaymentDates() {
			return interestLegPaymentDates;
		}
		
		@Override
		public InterestLegCalculationPeriodDates build() {
			return this;
		}
		
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder toBuilder() {
			InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getInterestLegResetDates()).ifPresent(builder::setInterestLegResetDates);
			ofNullable(getInterestLegPaymentDates()).ifPresent(builder::setInterestLegPaymentDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestLegCalculationPeriodDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(interestLegResetDates, _that.getInterestLegResetDates())) return false;
			if (!Objects.equals(interestLegPaymentDates, _that.getInterestLegPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (interestLegResetDates != null ? interestLegResetDates.hashCode() : 0);
			_result = 31 * _result + (interestLegPaymentDates != null ? interestLegPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestLegCalculationPeriodDates {" +
				"id=" + this.id + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"interestLegResetDates=" + this.interestLegResetDates + ", " +
				"interestLegPaymentDates=" + this.interestLegPaymentDates +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestLegCalculationPeriodDates  ***********************/
	class InterestLegCalculationPeriodDatesBuilderImpl implements InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder {
	
		protected String id;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
		protected InterestLegResetDates.InterestLegResetDatesBuilder interestLegResetDates;
		protected AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder interestLegPaymentDates;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestLegResetDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestLegResetDates")
		public InterestLegResetDates.InterestLegResetDatesBuilder getInterestLegResetDates() {
			return interestLegResetDates;
		}
		
		@Override
		public InterestLegResetDates.InterestLegResetDatesBuilder getOrCreateInterestLegResetDates() {
			InterestLegResetDates.InterestLegResetDatesBuilder result;
			if (interestLegResetDates!=null) {
				result = interestLegResetDates;
			}
			else {
				result = interestLegResetDates = InterestLegResetDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestLegPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestLegPaymentDates")
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getInterestLegPaymentDates() {
			return interestLegPaymentDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getOrCreateInterestLegPaymentDates() {
			AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder result;
			if (interestLegPaymentDates!=null) {
				result = interestLegPaymentDates;
			}
			else {
				result = interestLegPaymentDates = AdjustableRelativeOrPeriodicDates2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("id")
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interestLegResetDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interestLegResetDates")
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setInterestLegResetDates(InterestLegResetDates _interestLegResetDates) {
			this.interestLegResetDates = _interestLegResetDates == null ? null : _interestLegResetDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interestLegPaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interestLegPaymentDates")
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder setInterestLegPaymentDates(AdjustableRelativeOrPeriodicDates2 _interestLegPaymentDates) {
			this.interestLegPaymentDates = _interestLegPaymentDates == null ? null : _interestLegPaymentDates.toBuilder();
			return this;
		}
		
		@Override
		public InterestLegCalculationPeriodDates build() {
			return new InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesImpl(this);
		}
		
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (interestLegResetDates!=null && !interestLegResetDates.prune().hasData()) interestLegResetDates = null;
			if (interestLegPaymentDates!=null && !interestLegPaymentDates.prune().hasData()) interestLegPaymentDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getInterestLegResetDates()!=null && getInterestLegResetDates().hasData()) return true;
			if (getInterestLegPaymentDates()!=null && getInterestLegPaymentDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder o = (InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getInterestLegResetDates(), o.getInterestLegResetDates(), this::setInterestLegResetDates);
			merger.mergeRosetta(getInterestLegPaymentDates(), o.getInterestLegPaymentDates(), this::setInterestLegPaymentDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestLegCalculationPeriodDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(interestLegResetDates, _that.getInterestLegResetDates())) return false;
			if (!Objects.equals(interestLegPaymentDates, _that.getInterestLegPaymentDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (interestLegResetDates != null ? interestLegResetDates.hashCode() : 0);
			_result = 31 * _result + (interestLegPaymentDates != null ? interestLegPaymentDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestLegCalculationPeriodDatesBuilder {" +
				"id=" + this.id + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"interestLegResetDates=" + this.interestLegResetDates + ", " +
				"interestLegPaymentDates=" + this.interestLegPaymentDates +
			'}';
		}
	}
}
