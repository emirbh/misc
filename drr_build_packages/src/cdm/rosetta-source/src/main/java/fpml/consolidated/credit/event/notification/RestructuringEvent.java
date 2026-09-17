package fpml.consolidated.credit.event.notification;

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
import fpml.consolidated.credit.event.notification.meta.RestructuringEventMeta;
import fpml.consolidated.shared.Money;
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
@RosettaDataType(value="RestructuringEvent", builder=RestructuringEvent.RestructuringEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RestructuringEvent", model="fpml", builder=RestructuringEvent.RestructuringEventBuilderImpl.class, version="2.1.1")
public interface RestructuringEvent extends CreditEvent {

	RestructuringEventMeta metaData = new RestructuringEventMeta();

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
	Money getPartialExerciseAmount();

	/*********************** Build Methods  ***********************/
	RestructuringEvent build();
	
	RestructuringEvent.RestructuringEventBuilder toBuilder();
	
	static RestructuringEvent.RestructuringEventBuilder builder() {
		return new RestructuringEvent.RestructuringEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RestructuringEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RestructuringEvent> getType() {
		return RestructuringEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partialExerciseAmount"), processor, Money.class, getPartialExerciseAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RestructuringEventBuilder extends RestructuringEvent, CreditEvent.CreditEventBuilder {
		Money.MoneyBuilder getOrCreatePartialExerciseAmount();
		@Override
		Money.MoneyBuilder getPartialExerciseAmount();
		RestructuringEvent.RestructuringEventBuilder setPartialExerciseAmount(Money partialExerciseAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partialExerciseAmount"), processor, Money.MoneyBuilder.class, getPartialExerciseAmount());
		}
		

		RestructuringEvent.RestructuringEventBuilder prune();
	}

	/*********************** Immutable Implementation of RestructuringEvent  ***********************/
	class RestructuringEventImpl extends CreditEvent.CreditEventImpl implements RestructuringEvent {
		private final Money partialExerciseAmount;
		
		protected RestructuringEventImpl(RestructuringEvent.RestructuringEventBuilder builder) {
			super(builder);
			this.partialExerciseAmount = ofNullable(builder.getPartialExerciseAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partialExerciseAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partialExerciseAmount")
		public Money getPartialExerciseAmount() {
			return partialExerciseAmount;
		}
		
		@Override
		public RestructuringEvent build() {
			return this;
		}
		
		@Override
		public RestructuringEvent.RestructuringEventBuilder toBuilder() {
			RestructuringEvent.RestructuringEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RestructuringEvent.RestructuringEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPartialExerciseAmount()).ifPresent(builder::setPartialExerciseAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RestructuringEvent _that = getType().cast(o);
		
			if (!Objects.equals(partialExerciseAmount, _that.getPartialExerciseAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (partialExerciseAmount != null ? partialExerciseAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RestructuringEvent {" +
				"partialExerciseAmount=" + this.partialExerciseAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RestructuringEvent  ***********************/
	class RestructuringEventBuilderImpl extends CreditEvent.CreditEventBuilderImpl implements RestructuringEvent.RestructuringEventBuilder {
	
		protected Money.MoneyBuilder partialExerciseAmount;
		
		@Override
		@RosettaAttribute("partialExerciseAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partialExerciseAmount")
		public Money.MoneyBuilder getPartialExerciseAmount() {
			return partialExerciseAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePartialExerciseAmount() {
			Money.MoneyBuilder result;
			if (partialExerciseAmount!=null) {
				result = partialExerciseAmount;
			}
			else {
				result = partialExerciseAmount = Money.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("partialExerciseAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partialExerciseAmount")
		@Override
		public RestructuringEvent.RestructuringEventBuilder setPartialExerciseAmount(Money _partialExerciseAmount) {
			this.partialExerciseAmount = _partialExerciseAmount == null ? null : _partialExerciseAmount.toBuilder();
			return this;
		}
		
		@Override
		public RestructuringEvent build() {
			return new RestructuringEvent.RestructuringEventImpl(this);
		}
		
		@Override
		public RestructuringEvent.RestructuringEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RestructuringEvent.RestructuringEventBuilder prune() {
			super.prune();
			if (partialExerciseAmount!=null && !partialExerciseAmount.prune().hasData()) partialExerciseAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPartialExerciseAmount()!=null && getPartialExerciseAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RestructuringEvent.RestructuringEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RestructuringEvent.RestructuringEventBuilder o = (RestructuringEvent.RestructuringEventBuilder) other;
			
			merger.mergeRosetta(getPartialExerciseAmount(), o.getPartialExerciseAmount(), this::setPartialExerciseAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RestructuringEvent _that = getType().cast(o);
		
			if (!Objects.equals(partialExerciseAmount, _that.getPartialExerciseAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (partialExerciseAmount != null ? partialExerciseAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RestructuringEventBuilder {" +
				"partialExerciseAmount=" + this.partialExerciseAmount +
			'}' + " " + super.toString();
		}
	}
}
