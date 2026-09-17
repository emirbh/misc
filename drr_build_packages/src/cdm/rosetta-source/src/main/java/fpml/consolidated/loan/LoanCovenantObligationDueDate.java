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
import fpml.consolidated.loan.meta.LoanCovenantObligationDueDateMeta;
import fpml.consolidated.shared.DateOffset;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines the date, or series of dates, by which a covenant obligation must be met.
 *
 */
@RosettaDataType(value="LoanCovenantObligationDueDate", builder=LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationDueDate", model="fpml", builder=LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationDueDate extends RosettaModelObject {

	LoanCovenantObligationDueDateMeta metaData = new LoanCovenantObligationDueDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the date by which a covenant obligation must be met.
	 *
	 */
	ZonedDateTime getSpecificDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines an offset for a specific date, as applicable (e.g. if the date does not fall on a business date)
	 *
	 */
	DateOffset getDateOffset();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationDueDate build();
	
	LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder toBuilder();
	
	static LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder builder() {
		return new LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationDueDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationDueDate> getType() {
		return LoanCovenantObligationDueDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("specificDate"), ZonedDateTime.class, getSpecificDate(), this);
		processRosetta(path.newSubPath("dateOffset"), processor, DateOffset.class, getDateOffset());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationDueDateBuilder extends LoanCovenantObligationDueDate, RosettaModelObjectBuilder {
		DateOffset.DateOffsetBuilder getOrCreateDateOffset();
		@Override
		DateOffset.DateOffsetBuilder getDateOffset();
		LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder setSpecificDate(ZonedDateTime specificDate);
		LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder setDateOffset(DateOffset dateOffset);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("specificDate"), ZonedDateTime.class, getSpecificDate(), this);
			processRosetta(path.newSubPath("dateOffset"), processor, DateOffset.DateOffsetBuilder.class, getDateOffset());
		}
		

		LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationDueDate  ***********************/
	class LoanCovenantObligationDueDateImpl implements LoanCovenantObligationDueDate {
		private final ZonedDateTime specificDate;
		private final DateOffset dateOffset;
		
		protected LoanCovenantObligationDueDateImpl(LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder builder) {
			this.specificDate = builder.getSpecificDate();
			this.dateOffset = ofNullable(builder.getDateOffset()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("specificDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("specificDate")
		public ZonedDateTime getSpecificDate() {
			return specificDate;
		}
		
		@Override
		@RosettaAttribute("dateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateOffset")
		public DateOffset getDateOffset() {
			return dateOffset;
		}
		
		@Override
		public LoanCovenantObligationDueDate build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder toBuilder() {
			LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder builder) {
			ofNullable(getSpecificDate()).ifPresent(builder::setSpecificDate);
			ofNullable(getDateOffset()).ifPresent(builder::setDateOffset);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationDueDate _that = getType().cast(o);
		
			if (!Objects.equals(specificDate, _that.getSpecificDate())) return false;
			if (!Objects.equals(dateOffset, _that.getDateOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (specificDate != null ? specificDate.hashCode() : 0);
			_result = 31 * _result + (dateOffset != null ? dateOffset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationDueDate {" +
				"specificDate=" + this.specificDate + ", " +
				"dateOffset=" + this.dateOffset +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationDueDate  ***********************/
	class LoanCovenantObligationDueDateBuilderImpl implements LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder {
	
		protected ZonedDateTime specificDate;
		protected DateOffset.DateOffsetBuilder dateOffset;
		
		@Override
		@RosettaAttribute("specificDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("specificDate")
		public ZonedDateTime getSpecificDate() {
			return specificDate;
		}
		
		@Override
		@RosettaAttribute("dateOffset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateOffset")
		public DateOffset.DateOffsetBuilder getDateOffset() {
			return dateOffset;
		}
		
		@Override
		public DateOffset.DateOffsetBuilder getOrCreateDateOffset() {
			DateOffset.DateOffsetBuilder result;
			if (dateOffset!=null) {
				result = dateOffset;
			}
			else {
				result = dateOffset = DateOffset.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("specificDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("specificDate")
		@Override
		public LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder setSpecificDate(ZonedDateTime _specificDate) {
			this.specificDate = _specificDate == null ? null : _specificDate;
			return this;
		}
		
		@RosettaAttribute("dateOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateOffset")
		@Override
		public LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder setDateOffset(DateOffset _dateOffset) {
			this.dateOffset = _dateOffset == null ? null : _dateOffset.toBuilder();
			return this;
		}
		
		@Override
		public LoanCovenantObligationDueDate build() {
			return new LoanCovenantObligationDueDate.LoanCovenantObligationDueDateImpl(this);
		}
		
		@Override
		public LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder prune() {
			if (dateOffset!=null && !dateOffset.prune().hasData()) dateOffset = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpecificDate()!=null) return true;
			if (getDateOffset()!=null && getDateOffset().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder o = (LoanCovenantObligationDueDate.LoanCovenantObligationDueDateBuilder) other;
			
			merger.mergeRosetta(getDateOffset(), o.getDateOffset(), this::setDateOffset);
			
			merger.mergeBasic(getSpecificDate(), o.getSpecificDate(), this::setSpecificDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationDueDate _that = getType().cast(o);
		
			if (!Objects.equals(specificDate, _that.getSpecificDate())) return false;
			if (!Objects.equals(dateOffset, _that.getDateOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (specificDate != null ? specificDate.hashCode() : 0);
			_result = 31 * _result + (dateOffset != null ? dateOffset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationDueDateBuilder {" +
				"specificDate=" + this.specificDate + ", " +
				"dateOffset=" + this.dateOffset +
			'}';
		}
	}
}
