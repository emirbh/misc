package cdm.legaldocumentation.transaction.additionalterms;

import cdm.base.datetime.AdjustedRelativeDateOffset;
import cdm.legaldocumentation.transaction.additionalterms.meta.NonDeliverableSubstituteMeta;
import cdm.observable.asset.SettlementRateOption;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 6.23.0
 */
@RosettaDataType(value="NonDeliverableSubstitute", builder=NonDeliverableSubstitute.NonDeliverableSubstituteBuilderImpl.class, version="6.23.0")
@RuneDataType(value="NonDeliverableSubstitute", model="cdm", builder=NonDeliverableSubstitute.NonDeliverableSubstituteBuilderImpl.class, version="6.23.0")
public interface NonDeliverableSubstitute extends RosettaModelObject {

	NonDeliverableSubstituteMeta metaData = new NonDeliverableSubstituteMeta();

	/*********************** Getter Methods  ***********************/
	Boolean getNonDeliverableSubstituteIsApplicable();
	AdjustedRelativeDateOffset getValuationDate();
	AdjustedRelativeDateOffset getSettlementDate();
	SettlementRateOption getSettlementRateOption();

	/*********************** Build Methods  ***********************/
	NonDeliverableSubstitute build();
	
	NonDeliverableSubstitute.NonDeliverableSubstituteBuilder toBuilder();
	
	static NonDeliverableSubstitute.NonDeliverableSubstituteBuilder builder() {
		return new NonDeliverableSubstitute.NonDeliverableSubstituteBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonDeliverableSubstitute> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonDeliverableSubstitute> getType() {
		return NonDeliverableSubstitute.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("nonDeliverableSubstituteIsApplicable"), Boolean.class, getNonDeliverableSubstituteIsApplicable(), this);
		processRosetta(path.newSubPath("valuationDate"), processor, AdjustedRelativeDateOffset.class, getValuationDate());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustedRelativeDateOffset.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementRateOption"), processor, SettlementRateOption.class, getSettlementRateOption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonDeliverableSubstituteBuilder extends NonDeliverableSubstitute, RosettaModelObjectBuilder {
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getOrCreateValuationDate();
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getValuationDate();
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getOrCreateSettlementDate();
		@Override
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getSettlementDate();
		SettlementRateOption.SettlementRateOptionBuilder getOrCreateSettlementRateOption();
		@Override
		SettlementRateOption.SettlementRateOptionBuilder getSettlementRateOption();
		NonDeliverableSubstitute.NonDeliverableSubstituteBuilder setNonDeliverableSubstituteIsApplicable(Boolean nonDeliverableSubstituteIsApplicable);
		NonDeliverableSubstitute.NonDeliverableSubstituteBuilder setValuationDate(AdjustedRelativeDateOffset valuationDate);
		NonDeliverableSubstitute.NonDeliverableSubstituteBuilder setSettlementDate(AdjustedRelativeDateOffset settlementDate);
		NonDeliverableSubstitute.NonDeliverableSubstituteBuilder setSettlementRateOption(SettlementRateOption settlementRateOption);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("nonDeliverableSubstituteIsApplicable"), Boolean.class, getNonDeliverableSubstituteIsApplicable(), this);
			processRosetta(path.newSubPath("valuationDate"), processor, AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder.class, getValuationDate());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementRateOption"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getSettlementRateOption());
		}
		

		NonDeliverableSubstitute.NonDeliverableSubstituteBuilder prune();
	}

	/*********************** Immutable Implementation of NonDeliverableSubstitute  ***********************/
	class NonDeliverableSubstituteImpl implements NonDeliverableSubstitute {
		private final Boolean nonDeliverableSubstituteIsApplicable;
		private final AdjustedRelativeDateOffset valuationDate;
		private final AdjustedRelativeDateOffset settlementDate;
		private final SettlementRateOption settlementRateOption;
		
		protected NonDeliverableSubstituteImpl(NonDeliverableSubstitute.NonDeliverableSubstituteBuilder builder) {
			this.nonDeliverableSubstituteIsApplicable = builder.getNonDeliverableSubstituteIsApplicable();
			this.valuationDate = ofNullable(builder.getValuationDate()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.settlementRateOption = ofNullable(builder.getSettlementRateOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("nonDeliverableSubstituteIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nonDeliverableSubstituteIsApplicable")
		public Boolean getNonDeliverableSubstituteIsApplicable() {
			return nonDeliverableSubstituteIsApplicable;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public AdjustedRelativeDateOffset getValuationDate() {
			return valuationDate;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustedRelativeDateOffset getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementRateOption")
		public SettlementRateOption getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		public NonDeliverableSubstitute build() {
			return this;
		}
		
		@Override
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder toBuilder() {
			NonDeliverableSubstitute.NonDeliverableSubstituteBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonDeliverableSubstitute.NonDeliverableSubstituteBuilder builder) {
			ofNullable(getNonDeliverableSubstituteIsApplicable()).ifPresent(builder::setNonDeliverableSubstituteIsApplicable);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getSettlementRateOption()).ifPresent(builder::setSettlementRateOption);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonDeliverableSubstitute _that = getType().cast(o);
		
			if (!Objects.equals(nonDeliverableSubstituteIsApplicable, _that.getNonDeliverableSubstituteIsApplicable())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonDeliverableSubstituteIsApplicable != null ? nonDeliverableSubstituteIsApplicable.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonDeliverableSubstitute {" +
				"nonDeliverableSubstituteIsApplicable=" + this.nonDeliverableSubstituteIsApplicable + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementRateOption=" + this.settlementRateOption +
			'}';
		}
	}

	/*********************** Builder Implementation of NonDeliverableSubstitute  ***********************/
	class NonDeliverableSubstituteBuilderImpl implements NonDeliverableSubstitute.NonDeliverableSubstituteBuilder {
	
		protected Boolean nonDeliverableSubstituteIsApplicable;
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder valuationDate;
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder settlementDate;
		protected SettlementRateOption.SettlementRateOptionBuilder settlementRateOption;
		
		@Override
		@RosettaAttribute("nonDeliverableSubstituteIsApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nonDeliverableSubstituteIsApplicable")
		public Boolean getNonDeliverableSubstituteIsApplicable() {
			return nonDeliverableSubstituteIsApplicable;
		}
		
		@Override
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDate")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getOrCreateValuationDate() {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder result;
			if (valuationDate!=null) {
				result = valuationDate;
			}
			else {
				result = valuationDate = AdjustedRelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder getOrCreateSettlementDate() {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustedRelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementRateOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementRateOption")
		public SettlementRateOption.SettlementRateOptionBuilder getSettlementRateOption() {
			return settlementRateOption;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder getOrCreateSettlementRateOption() {
			SettlementRateOption.SettlementRateOptionBuilder result;
			if (settlementRateOption!=null) {
				result = settlementRateOption;
			}
			else {
				result = settlementRateOption = SettlementRateOption.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("nonDeliverableSubstituteIsApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nonDeliverableSubstituteIsApplicable")
		@Override
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder setNonDeliverableSubstituteIsApplicable(Boolean _nonDeliverableSubstituteIsApplicable) {
			this.nonDeliverableSubstituteIsApplicable = _nonDeliverableSubstituteIsApplicable == null ? null : _nonDeliverableSubstituteIsApplicable;
			return this;
		}
		
		@RosettaAttribute("valuationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDate")
		@Override
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder setValuationDate(AdjustedRelativeDateOffset _valuationDate) {
			this.valuationDate = _valuationDate == null ? null : _valuationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder setSettlementDate(AdjustedRelativeDateOffset _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementRateOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementRateOption")
		@Override
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder setSettlementRateOption(SettlementRateOption _settlementRateOption) {
			this.settlementRateOption = _settlementRateOption == null ? null : _settlementRateOption.toBuilder();
			return this;
		}
		
		@Override
		public NonDeliverableSubstitute build() {
			return new NonDeliverableSubstitute.NonDeliverableSubstituteImpl(this);
		}
		
		@Override
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder prune() {
			if (valuationDate!=null && !valuationDate.prune().hasData()) valuationDate = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (settlementRateOption!=null && !settlementRateOption.prune().hasData()) settlementRateOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNonDeliverableSubstituteIsApplicable()!=null) return true;
			if (getValuationDate()!=null && getValuationDate().hasData()) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getSettlementRateOption()!=null && getSettlementRateOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonDeliverableSubstitute.NonDeliverableSubstituteBuilder o = (NonDeliverableSubstitute.NonDeliverableSubstituteBuilder) other;
			
			merger.mergeRosetta(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getSettlementRateOption(), o.getSettlementRateOption(), this::setSettlementRateOption);
			
			merger.mergeBasic(getNonDeliverableSubstituteIsApplicable(), o.getNonDeliverableSubstituteIsApplicable(), this::setNonDeliverableSubstituteIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonDeliverableSubstitute _that = getType().cast(o);
		
			if (!Objects.equals(nonDeliverableSubstituteIsApplicable, _that.getNonDeliverableSubstituteIsApplicable())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementRateOption, _that.getSettlementRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nonDeliverableSubstituteIsApplicable != null ? nonDeliverableSubstituteIsApplicable.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementRateOption != null ? settlementRateOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonDeliverableSubstituteBuilder {" +
				"nonDeliverableSubstituteIsApplicable=" + this.nonDeliverableSubstituteIsApplicable + ", " +
				"valuationDate=" + this.valuationDate + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementRateOption=" + this.settlementRateOption +
			'}';
		}
	}
}
