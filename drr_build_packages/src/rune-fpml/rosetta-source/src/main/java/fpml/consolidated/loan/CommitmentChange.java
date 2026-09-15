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
import fpml.consolidated.loan.meta.CommitmentChangeMeta;
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
 * Provision A structure which specifies the commitment changes occurring throughout the life of a facility.
 *
 */
@RosettaDataType(value="CommitmentChange", builder=CommitmentChange.CommitmentChangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommitmentChange", model="fpml", builder=CommitmentChange.CommitmentChangeBuilderImpl.class, version="2.1.1")
public interface CommitmentChange extends RosettaModelObject {

	CommitmentChangeMeta metaData = new CommitmentChangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which a facility increase/decrease has/will occur.
	 *
	 */
	ZonedDateTime getDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The total remaining commitment amount (in facility currency), once the adjustment has been applied.
	 *
	 */
	Adjustment getAdjustment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The total remaining commitment amount (in facility currency), once the adjustment has been applied.
	 *
	 */
	MoneyWithParticipantShare getRemaining();

	/*********************** Build Methods  ***********************/
	CommitmentChange build();
	
	CommitmentChange.CommitmentChangeBuilder toBuilder();
	
	static CommitmentChange.CommitmentChangeBuilder builder() {
		return new CommitmentChange.CommitmentChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommitmentChange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommitmentChange> getType() {
		return CommitmentChange.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
		processRosetta(path.newSubPath("adjustment"), processor, Adjustment.class, getAdjustment());
		processRosetta(path.newSubPath("remaining"), processor, MoneyWithParticipantShare.class, getRemaining());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommitmentChangeBuilder extends CommitmentChange, RosettaModelObjectBuilder {
		Adjustment.AdjustmentBuilder getOrCreateAdjustment();
		@Override
		Adjustment.AdjustmentBuilder getAdjustment();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateRemaining();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getRemaining();
		CommitmentChange.CommitmentChangeBuilder setDate(ZonedDateTime date);
		CommitmentChange.CommitmentChangeBuilder setAdjustment(Adjustment adjustment);
		CommitmentChange.CommitmentChangeBuilder setRemaining(MoneyWithParticipantShare remaining);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("date"), ZonedDateTime.class, getDate(), this);
			processRosetta(path.newSubPath("adjustment"), processor, Adjustment.AdjustmentBuilder.class, getAdjustment());
			processRosetta(path.newSubPath("remaining"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getRemaining());
		}
		

		CommitmentChange.CommitmentChangeBuilder prune();
	}

	/*********************** Immutable Implementation of CommitmentChange  ***********************/
	class CommitmentChangeImpl implements CommitmentChange {
		private final ZonedDateTime date;
		private final Adjustment adjustment;
		private final MoneyWithParticipantShare remaining;
		
		protected CommitmentChangeImpl(CommitmentChange.CommitmentChangeBuilder builder) {
			this.date = builder.getDate();
			this.adjustment = ofNullable(builder.getAdjustment()).map(f->f.build()).orElse(null);
			this.remaining = ofNullable(builder.getRemaining()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustment")
		public Adjustment getAdjustment() {
			return adjustment;
		}
		
		@Override
		@RosettaAttribute("remaining")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("remaining")
		public MoneyWithParticipantShare getRemaining() {
			return remaining;
		}
		
		@Override
		public CommitmentChange build() {
			return this;
		}
		
		@Override
		public CommitmentChange.CommitmentChangeBuilder toBuilder() {
			CommitmentChange.CommitmentChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommitmentChange.CommitmentChangeBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getAdjustment()).ifPresent(builder::setAdjustment);
			ofNullable(getRemaining()).ifPresent(builder::setRemaining);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommitmentChange _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(remaining, _that.getRemaining())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (remaining != null ? remaining.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommitmentChange {" +
				"date=" + this.date + ", " +
				"adjustment=" + this.adjustment + ", " +
				"remaining=" + this.remaining +
			'}';
		}
	}

	/*********************** Builder Implementation of CommitmentChange  ***********************/
	class CommitmentChangeBuilderImpl implements CommitmentChange.CommitmentChangeBuilder {
	
		protected ZonedDateTime date;
		protected Adjustment.AdjustmentBuilder adjustment;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder remaining;
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("date")
		public ZonedDateTime getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustment")
		public Adjustment.AdjustmentBuilder getAdjustment() {
			return adjustment;
		}
		
		@Override
		public Adjustment.AdjustmentBuilder getOrCreateAdjustment() {
			Adjustment.AdjustmentBuilder result;
			if (adjustment!=null) {
				result = adjustment;
			}
			else {
				result = adjustment = Adjustment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("remaining")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("remaining")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getRemaining() {
			return remaining;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateRemaining() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (remaining!=null) {
				result = remaining;
			}
			else {
				result = remaining = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("date")
		@Override
		public CommitmentChange.CommitmentChangeBuilder setDate(ZonedDateTime _date) {
			this.date = _date == null ? null : _date;
			return this;
		}
		
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("adjustment")
		@Override
		public CommitmentChange.CommitmentChangeBuilder setAdjustment(Adjustment _adjustment) {
			this.adjustment = _adjustment == null ? null : _adjustment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("remaining")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("remaining")
		@Override
		public CommitmentChange.CommitmentChangeBuilder setRemaining(MoneyWithParticipantShare _remaining) {
			this.remaining = _remaining == null ? null : _remaining.toBuilder();
			return this;
		}
		
		@Override
		public CommitmentChange build() {
			return new CommitmentChange.CommitmentChangeImpl(this);
		}
		
		@Override
		public CommitmentChange.CommitmentChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommitmentChange.CommitmentChangeBuilder prune() {
			if (adjustment!=null && !adjustment.prune().hasData()) adjustment = null;
			if (remaining!=null && !remaining.prune().hasData()) remaining = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null) return true;
			if (getAdjustment()!=null && getAdjustment().hasData()) return true;
			if (getRemaining()!=null && getRemaining().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommitmentChange.CommitmentChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommitmentChange.CommitmentChangeBuilder o = (CommitmentChange.CommitmentChangeBuilder) other;
			
			merger.mergeRosetta(getAdjustment(), o.getAdjustment(), this::setAdjustment);
			merger.mergeRosetta(getRemaining(), o.getRemaining(), this::setRemaining);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommitmentChange _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(remaining, _that.getRemaining())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (remaining != null ? remaining.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommitmentChangeBuilder {" +
				"date=" + this.date + ", " +
				"adjustment=" + this.adjustment + ", " +
				"remaining=" + this.remaining +
			'}';
		}
	}
}
