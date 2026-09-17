package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.FacilityCommitmentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that represents the commitment amount against a facility or facility portion. Also shows the utilization levels against the total commitment amount (in facility currency).
 *
 */
@RosettaDataType(value="FacilityCommitment", builder=FacilityCommitment.FacilityCommitmentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FacilityCommitment", model="fpml", builder=FacilityCommitment.FacilityCommitmentBuilderImpl.class, version="2.1.1")
public interface FacilityCommitment extends RosettaModelObject {

	FacilityCommitmentMeta metaData = new FacilityCommitmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The total commitment level associated with the facility or facility portion (in facility currency).
	 *
	 */
	MoneyWithParticipantShare getTotalCommitmentAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of utilization which is funded.
	 *
	 */
	MoneyWithParticipantShare getRequiredFundedAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of utilization which is unfunded.
	 *
	 */
	MoneyWithParticipantShare getUnfundedAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of utilization which is unfunded.
	 *
	 */
	MoneyWithParticipantShare getRequiredUnfundedAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The amount of utilization which is funded.
	 *
	 */
	MoneyWithParticipantShare getFundedAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The portion of the commitment amount which is NOT available for the borrower to draw against.
	 *
	 */
	MoneyWithParticipantShare getUnavailableToUtilizeAmount();

	/*********************** Build Methods  ***********************/
	FacilityCommitment build();
	
	FacilityCommitment.FacilityCommitmentBuilder toBuilder();
	
	static FacilityCommitment.FacilityCommitmentBuilder builder() {
		return new FacilityCommitment.FacilityCommitmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityCommitment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FacilityCommitment> getType() {
		return FacilityCommitment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("totalCommitmentAmount"), processor, MoneyWithParticipantShare.class, getTotalCommitmentAmount());
		processRosetta(path.newSubPath("requiredFundedAmount"), processor, MoneyWithParticipantShare.class, getRequiredFundedAmount());
		processRosetta(path.newSubPath("unfundedAmount"), processor, MoneyWithParticipantShare.class, getUnfundedAmount());
		processRosetta(path.newSubPath("requiredUnfundedAmount"), processor, MoneyWithParticipantShare.class, getRequiredUnfundedAmount());
		processRosetta(path.newSubPath("fundedAmount"), processor, MoneyWithParticipantShare.class, getFundedAmount());
		processRosetta(path.newSubPath("unavailableToUtilizeAmount"), processor, MoneyWithParticipantShare.class, getUnavailableToUtilizeAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityCommitmentBuilder extends FacilityCommitment, RosettaModelObjectBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateTotalCommitmentAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getTotalCommitmentAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateRequiredFundedAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getRequiredFundedAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateUnfundedAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getUnfundedAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateRequiredUnfundedAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getRequiredUnfundedAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateFundedAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getFundedAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateUnavailableToUtilizeAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getUnavailableToUtilizeAmount();
		FacilityCommitment.FacilityCommitmentBuilder setTotalCommitmentAmount(MoneyWithParticipantShare totalCommitmentAmount);
		FacilityCommitment.FacilityCommitmentBuilder setRequiredFundedAmount(MoneyWithParticipantShare requiredFundedAmount);
		FacilityCommitment.FacilityCommitmentBuilder setUnfundedAmount(MoneyWithParticipantShare unfundedAmount);
		FacilityCommitment.FacilityCommitmentBuilder setRequiredUnfundedAmount(MoneyWithParticipantShare requiredUnfundedAmount);
		FacilityCommitment.FacilityCommitmentBuilder setFundedAmount(MoneyWithParticipantShare fundedAmount);
		FacilityCommitment.FacilityCommitmentBuilder setUnavailableToUtilizeAmount(MoneyWithParticipantShare unavailableToUtilizeAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("totalCommitmentAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getTotalCommitmentAmount());
			processRosetta(path.newSubPath("requiredFundedAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getRequiredFundedAmount());
			processRosetta(path.newSubPath("unfundedAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getUnfundedAmount());
			processRosetta(path.newSubPath("requiredUnfundedAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getRequiredUnfundedAmount());
			processRosetta(path.newSubPath("fundedAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getFundedAmount());
			processRosetta(path.newSubPath("unavailableToUtilizeAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getUnavailableToUtilizeAmount());
		}
		

		FacilityCommitment.FacilityCommitmentBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityCommitment  ***********************/
	class FacilityCommitmentImpl implements FacilityCommitment {
		private final MoneyWithParticipantShare totalCommitmentAmount;
		private final MoneyWithParticipantShare requiredFundedAmount;
		private final MoneyWithParticipantShare unfundedAmount;
		private final MoneyWithParticipantShare requiredUnfundedAmount;
		private final MoneyWithParticipantShare fundedAmount;
		private final MoneyWithParticipantShare unavailableToUtilizeAmount;
		
		protected FacilityCommitmentImpl(FacilityCommitment.FacilityCommitmentBuilder builder) {
			this.totalCommitmentAmount = ofNullable(builder.getTotalCommitmentAmount()).map(f->f.build()).orElse(null);
			this.requiredFundedAmount = ofNullable(builder.getRequiredFundedAmount()).map(f->f.build()).orElse(null);
			this.unfundedAmount = ofNullable(builder.getUnfundedAmount()).map(f->f.build()).orElse(null);
			this.requiredUnfundedAmount = ofNullable(builder.getRequiredUnfundedAmount()).map(f->f.build()).orElse(null);
			this.fundedAmount = ofNullable(builder.getFundedAmount()).map(f->f.build()).orElse(null);
			this.unavailableToUtilizeAmount = ofNullable(builder.getUnavailableToUtilizeAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("totalCommitmentAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("totalCommitmentAmount")
		public MoneyWithParticipantShare getTotalCommitmentAmount() {
			return totalCommitmentAmount;
		}
		
		@Override
		@RosettaAttribute("requiredFundedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requiredFundedAmount")
		public MoneyWithParticipantShare getRequiredFundedAmount() {
			return requiredFundedAmount;
		}
		
		@Override
		@RosettaAttribute("unfundedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unfundedAmount")
		public MoneyWithParticipantShare getUnfundedAmount() {
			return unfundedAmount;
		}
		
		@Override
		@RosettaAttribute("requiredUnfundedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requiredUnfundedAmount")
		public MoneyWithParticipantShare getRequiredUnfundedAmount() {
			return requiredUnfundedAmount;
		}
		
		@Override
		@RosettaAttribute("fundedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fundedAmount")
		public MoneyWithParticipantShare getFundedAmount() {
			return fundedAmount;
		}
		
		@Override
		@RosettaAttribute("unavailableToUtilizeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unavailableToUtilizeAmount")
		public MoneyWithParticipantShare getUnavailableToUtilizeAmount() {
			return unavailableToUtilizeAmount;
		}
		
		@Override
		public FacilityCommitment build() {
			return this;
		}
		
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder toBuilder() {
			FacilityCommitment.FacilityCommitmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityCommitment.FacilityCommitmentBuilder builder) {
			ofNullable(getTotalCommitmentAmount()).ifPresent(builder::setTotalCommitmentAmount);
			ofNullable(getRequiredFundedAmount()).ifPresent(builder::setRequiredFundedAmount);
			ofNullable(getUnfundedAmount()).ifPresent(builder::setUnfundedAmount);
			ofNullable(getRequiredUnfundedAmount()).ifPresent(builder::setRequiredUnfundedAmount);
			ofNullable(getFundedAmount()).ifPresent(builder::setFundedAmount);
			ofNullable(getUnavailableToUtilizeAmount()).ifPresent(builder::setUnavailableToUtilizeAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityCommitment _that = getType().cast(o);
		
			if (!Objects.equals(totalCommitmentAmount, _that.getTotalCommitmentAmount())) return false;
			if (!Objects.equals(requiredFundedAmount, _that.getRequiredFundedAmount())) return false;
			if (!Objects.equals(unfundedAmount, _that.getUnfundedAmount())) return false;
			if (!Objects.equals(requiredUnfundedAmount, _that.getRequiredUnfundedAmount())) return false;
			if (!Objects.equals(fundedAmount, _that.getFundedAmount())) return false;
			if (!Objects.equals(unavailableToUtilizeAmount, _that.getUnavailableToUtilizeAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (totalCommitmentAmount != null ? totalCommitmentAmount.hashCode() : 0);
			_result = 31 * _result + (requiredFundedAmount != null ? requiredFundedAmount.hashCode() : 0);
			_result = 31 * _result + (unfundedAmount != null ? unfundedAmount.hashCode() : 0);
			_result = 31 * _result + (requiredUnfundedAmount != null ? requiredUnfundedAmount.hashCode() : 0);
			_result = 31 * _result + (fundedAmount != null ? fundedAmount.hashCode() : 0);
			_result = 31 * _result + (unavailableToUtilizeAmount != null ? unavailableToUtilizeAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityCommitment {" +
				"totalCommitmentAmount=" + this.totalCommitmentAmount + ", " +
				"requiredFundedAmount=" + this.requiredFundedAmount + ", " +
				"unfundedAmount=" + this.unfundedAmount + ", " +
				"requiredUnfundedAmount=" + this.requiredUnfundedAmount + ", " +
				"fundedAmount=" + this.fundedAmount + ", " +
				"unavailableToUtilizeAmount=" + this.unavailableToUtilizeAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityCommitment  ***********************/
	class FacilityCommitmentBuilderImpl implements FacilityCommitment.FacilityCommitmentBuilder {
	
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder totalCommitmentAmount;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder requiredFundedAmount;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder unfundedAmount;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder requiredUnfundedAmount;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder fundedAmount;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder unavailableToUtilizeAmount;
		
		@Override
		@RosettaAttribute("totalCommitmentAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("totalCommitmentAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getTotalCommitmentAmount() {
			return totalCommitmentAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateTotalCommitmentAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (totalCommitmentAmount!=null) {
				result = totalCommitmentAmount;
			}
			else {
				result = totalCommitmentAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("requiredFundedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requiredFundedAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getRequiredFundedAmount() {
			return requiredFundedAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateRequiredFundedAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (requiredFundedAmount!=null) {
				result = requiredFundedAmount;
			}
			else {
				result = requiredFundedAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("unfundedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unfundedAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getUnfundedAmount() {
			return unfundedAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateUnfundedAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (unfundedAmount!=null) {
				result = unfundedAmount;
			}
			else {
				result = unfundedAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("requiredUnfundedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("requiredUnfundedAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getRequiredUnfundedAmount() {
			return requiredUnfundedAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateRequiredUnfundedAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (requiredUnfundedAmount!=null) {
				result = requiredUnfundedAmount;
			}
			else {
				result = requiredUnfundedAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fundedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fundedAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getFundedAmount() {
			return fundedAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateFundedAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (fundedAmount!=null) {
				result = fundedAmount;
			}
			else {
				result = fundedAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("unavailableToUtilizeAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unavailableToUtilizeAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getUnavailableToUtilizeAmount() {
			return unavailableToUtilizeAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateUnavailableToUtilizeAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (unavailableToUtilizeAmount!=null) {
				result = unavailableToUtilizeAmount;
			}
			else {
				result = unavailableToUtilizeAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("totalCommitmentAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("totalCommitmentAmount")
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder setTotalCommitmentAmount(MoneyWithParticipantShare _totalCommitmentAmount) {
			this.totalCommitmentAmount = _totalCommitmentAmount == null ? null : _totalCommitmentAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("requiredFundedAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("requiredFundedAmount")
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder setRequiredFundedAmount(MoneyWithParticipantShare _requiredFundedAmount) {
			this.requiredFundedAmount = _requiredFundedAmount == null ? null : _requiredFundedAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("unfundedAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unfundedAmount")
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder setUnfundedAmount(MoneyWithParticipantShare _unfundedAmount) {
			this.unfundedAmount = _unfundedAmount == null ? null : _unfundedAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("requiredUnfundedAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("requiredUnfundedAmount")
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder setRequiredUnfundedAmount(MoneyWithParticipantShare _requiredUnfundedAmount) {
			this.requiredUnfundedAmount = _requiredUnfundedAmount == null ? null : _requiredUnfundedAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fundedAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fundedAmount")
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder setFundedAmount(MoneyWithParticipantShare _fundedAmount) {
			this.fundedAmount = _fundedAmount == null ? null : _fundedAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("unavailableToUtilizeAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unavailableToUtilizeAmount")
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder setUnavailableToUtilizeAmount(MoneyWithParticipantShare _unavailableToUtilizeAmount) {
			this.unavailableToUtilizeAmount = _unavailableToUtilizeAmount == null ? null : _unavailableToUtilizeAmount.toBuilder();
			return this;
		}
		
		@Override
		public FacilityCommitment build() {
			return new FacilityCommitment.FacilityCommitmentImpl(this);
		}
		
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder prune() {
			if (totalCommitmentAmount!=null && !totalCommitmentAmount.prune().hasData()) totalCommitmentAmount = null;
			if (requiredFundedAmount!=null && !requiredFundedAmount.prune().hasData()) requiredFundedAmount = null;
			if (unfundedAmount!=null && !unfundedAmount.prune().hasData()) unfundedAmount = null;
			if (requiredUnfundedAmount!=null && !requiredUnfundedAmount.prune().hasData()) requiredUnfundedAmount = null;
			if (fundedAmount!=null && !fundedAmount.prune().hasData()) fundedAmount = null;
			if (unavailableToUtilizeAmount!=null && !unavailableToUtilizeAmount.prune().hasData()) unavailableToUtilizeAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTotalCommitmentAmount()!=null && getTotalCommitmentAmount().hasData()) return true;
			if (getRequiredFundedAmount()!=null && getRequiredFundedAmount().hasData()) return true;
			if (getUnfundedAmount()!=null && getUnfundedAmount().hasData()) return true;
			if (getRequiredUnfundedAmount()!=null && getRequiredUnfundedAmount().hasData()) return true;
			if (getFundedAmount()!=null && getFundedAmount().hasData()) return true;
			if (getUnavailableToUtilizeAmount()!=null && getUnavailableToUtilizeAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityCommitment.FacilityCommitmentBuilder o = (FacilityCommitment.FacilityCommitmentBuilder) other;
			
			merger.mergeRosetta(getTotalCommitmentAmount(), o.getTotalCommitmentAmount(), this::setTotalCommitmentAmount);
			merger.mergeRosetta(getRequiredFundedAmount(), o.getRequiredFundedAmount(), this::setRequiredFundedAmount);
			merger.mergeRosetta(getUnfundedAmount(), o.getUnfundedAmount(), this::setUnfundedAmount);
			merger.mergeRosetta(getRequiredUnfundedAmount(), o.getRequiredUnfundedAmount(), this::setRequiredUnfundedAmount);
			merger.mergeRosetta(getFundedAmount(), o.getFundedAmount(), this::setFundedAmount);
			merger.mergeRosetta(getUnavailableToUtilizeAmount(), o.getUnavailableToUtilizeAmount(), this::setUnavailableToUtilizeAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityCommitment _that = getType().cast(o);
		
			if (!Objects.equals(totalCommitmentAmount, _that.getTotalCommitmentAmount())) return false;
			if (!Objects.equals(requiredFundedAmount, _that.getRequiredFundedAmount())) return false;
			if (!Objects.equals(unfundedAmount, _that.getUnfundedAmount())) return false;
			if (!Objects.equals(requiredUnfundedAmount, _that.getRequiredUnfundedAmount())) return false;
			if (!Objects.equals(fundedAmount, _that.getFundedAmount())) return false;
			if (!Objects.equals(unavailableToUtilizeAmount, _that.getUnavailableToUtilizeAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (totalCommitmentAmount != null ? totalCommitmentAmount.hashCode() : 0);
			_result = 31 * _result + (requiredFundedAmount != null ? requiredFundedAmount.hashCode() : 0);
			_result = 31 * _result + (unfundedAmount != null ? unfundedAmount.hashCode() : 0);
			_result = 31 * _result + (requiredUnfundedAmount != null ? requiredUnfundedAmount.hashCode() : 0);
			_result = 31 * _result + (fundedAmount != null ? fundedAmount.hashCode() : 0);
			_result = 31 * _result + (unavailableToUtilizeAmount != null ? unavailableToUtilizeAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityCommitmentBuilder {" +
				"totalCommitmentAmount=" + this.totalCommitmentAmount + ", " +
				"requiredFundedAmount=" + this.requiredFundedAmount + ", " +
				"unfundedAmount=" + this.unfundedAmount + ", " +
				"requiredUnfundedAmount=" + this.requiredUnfundedAmount + ", " +
				"fundedAmount=" + this.fundedAmount + ", " +
				"unavailableToUtilizeAmount=" + this.unavailableToUtilizeAmount +
			'}';
		}
	}
}
