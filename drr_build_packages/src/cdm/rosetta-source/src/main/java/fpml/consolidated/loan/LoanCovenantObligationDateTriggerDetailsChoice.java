package fpml.consolidated.loan;

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
import fpml.consolidated.fpmlenum.ReportingFrequencyTypeEnum;
import fpml.consolidated.loan.meta.LoanCovenantObligationDateTriggerDetailsChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="LoanCovenantObligationDateTriggerDetailsChoice", builder=LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationDateTriggerDetailsChoice", model="fpml", builder=LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationDateTriggerDetailsChoice extends RosettaModelObject {

	LoanCovenantObligationDateTriggerDetailsChoiceMeta metaData = new LoanCovenantObligationDateTriggerDetailsChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the date, or series of dates, by which a covenant obligation must be met.
	 *
	 */
	LoanCovenantObligationDueDate getDueDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the recurring due date for a covenant obligation, as derived based on the borrower's/issuer's fiscal calendar.
	 *
	 */
	ReportingFrequencyTypeEnum getFrequencyType();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationDateTriggerDetailsChoice build();
	
	LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder toBuilder();
	
	static LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder builder() {
		return new LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationDateTriggerDetailsChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationDateTriggerDetailsChoice> getType() {
		return LoanCovenantObligationDateTriggerDetailsChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dueDate"), processor, LoanCovenantObligationDueDate.class, getDueDate());
		processor.processBasic(path.newSubPath("frequencyType"), ReportingFrequencyTypeEnum.class, getFrequencyType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationDateTriggerDetailsChoiceBuilder extends LoanCovenantObligationDateTriggerDetailsChoice, RosettaModelObjectBuilder {
		LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder getOrCreateDueDate();
		@Override
		LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder getDueDate();
		LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder setDueDate(LoanCovenantObligationDueDate dueDate);
		LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder setFrequencyType(ReportingFrequencyTypeEnum frequencyType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dueDate"), processor, LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder.class, getDueDate());
			processor.processBasic(path.newSubPath("frequencyType"), ReportingFrequencyTypeEnum.class, getFrequencyType(), this);
		}
		

		LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationDateTriggerDetailsChoice  ***********************/
	class LoanCovenantObligationDateTriggerDetailsChoiceImpl implements LoanCovenantObligationDateTriggerDetailsChoice {
		private final LoanCovenantObligationDueDate dueDate;
		private final ReportingFrequencyTypeEnum frequencyType;
		
		protected LoanCovenantObligationDateTriggerDetailsChoiceImpl(LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder builder) {
			this.dueDate = ofNullable(builder.getDueDate()).map(f->f.build()).orElse(null);
			this.frequencyType = builder.getFrequencyType();
		}
		
		@Override
		@RosettaAttribute("dueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dueDate")
		public LoanCovenantObligationDueDate getDueDate() {
			return dueDate;
		}
		
		@Override
		@RosettaAttribute("frequencyType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frequencyType")
		public ReportingFrequencyTypeEnum getFrequencyType() {
			return frequencyType;
		}
		
		@Override
		public LoanCovenantObligationDateTriggerDetailsChoice build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder toBuilder() {
			LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder builder) {
			ofNullable(getDueDate()).ifPresent(builder::setDueDate);
			ofNullable(getFrequencyType()).ifPresent(builder::setFrequencyType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationDateTriggerDetailsChoice _that = getType().cast(o);
		
			if (!Objects.equals(dueDate, _that.getDueDate())) return false;
			if (!Objects.equals(frequencyType, _that.getFrequencyType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dueDate != null ? dueDate.hashCode() : 0);
			_result = 31 * _result + (frequencyType != null ? frequencyType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationDateTriggerDetailsChoice {" +
				"dueDate=" + this.dueDate + ", " +
				"frequencyType=" + this.frequencyType +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationDateTriggerDetailsChoice  ***********************/
	class LoanCovenantObligationDateTriggerDetailsChoiceBuilderImpl implements LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder {
	
		protected LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder dueDate;
		protected ReportingFrequencyTypeEnum frequencyType;
		
		@Override
		@RosettaAttribute("dueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dueDate")
		public LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder getDueDate() {
			return dueDate;
		}
		
		@Override
		public LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder getOrCreateDueDate() {
			LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder result;
			if (dueDate!=null) {
				result = dueDate;
			}
			else {
				result = dueDate = LoanCovenantObligationDueDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("frequencyType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frequencyType")
		public ReportingFrequencyTypeEnum getFrequencyType() {
			return frequencyType;
		}
		
		@RosettaAttribute("dueDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dueDate")
		@Override
		public LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder setDueDate(LoanCovenantObligationDueDate _dueDate) {
			this.dueDate = _dueDate == null ? null : _dueDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("frequencyType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("frequencyType")
		@Override
		public LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder setFrequencyType(ReportingFrequencyTypeEnum _frequencyType) {
			this.frequencyType = _frequencyType == null ? null : _frequencyType;
			return this;
		}
		
		@Override
		public LoanCovenantObligationDateTriggerDetailsChoice build() {
			return new LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceImpl(this);
		}
		
		@Override
		public LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder prune() {
			if (dueDate!=null && !dueDate.prune().hasData()) dueDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDueDate()!=null && getDueDate().hasData()) return true;
			if (getFrequencyType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder o = (LoanCovenantObligationDateTriggerDetailsChoice.LoanCovenantObligationDateTriggerDetailsChoiceBuilder) other;
			
			merger.mergeRosetta(getDueDate(), o.getDueDate(), this::setDueDate);
			
			merger.mergeBasic(getFrequencyType(), o.getFrequencyType(), this::setFrequencyType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationDateTriggerDetailsChoice _that = getType().cast(o);
		
			if (!Objects.equals(dueDate, _that.getDueDate())) return false;
			if (!Objects.equals(frequencyType, _that.getFrequencyType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dueDate != null ? dueDate.hashCode() : 0);
			_result = 31 * _result + (frequencyType != null ? frequencyType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationDateTriggerDetailsChoiceBuilder {" +
				"dueDate=" + this.dueDate + ", " +
				"frequencyType=" + this.frequencyType +
			'}';
		}
	}
}
