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
import fpml.consolidated.fpmlenum.AmountAdjustmentEnum;
import fpml.consolidated.loan.meta.AdjustmentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to describe an adjustment.
 *
 */
@RosettaDataType(value="Adjustment", builder=Adjustment.AdjustmentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Adjustment", model="fpml", builder=Adjustment.AdjustmentBuilderImpl.class, version="2.1.1")
public interface Adjustment extends RosettaModelObject {

	AdjustmentMeta metaData = new AdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the type of adjustment applied - increase or decrease.
	 *
	 */
	AmountAdjustmentEnum getAdjustmentType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	MoneyWithParticipantShare getAmount();

	/*********************** Build Methods  ***********************/
	Adjustment build();
	
	Adjustment.AdjustmentBuilder toBuilder();
	
	static Adjustment.AdjustmentBuilder builder() {
		return new Adjustment.AdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Adjustment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Adjustment> getType() {
		return Adjustment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustmentType"), AmountAdjustmentEnum.class, getAdjustmentType(), this);
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustmentBuilder extends Adjustment, RosettaModelObjectBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount();
		Adjustment.AdjustmentBuilder setAdjustmentType(AmountAdjustmentEnum adjustmentType);
		Adjustment.AdjustmentBuilder setAmount(MoneyWithParticipantShare amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("adjustmentType"), AmountAdjustmentEnum.class, getAdjustmentType(), this);
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
		}
		

		Adjustment.AdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of Adjustment  ***********************/
	class AdjustmentImpl implements Adjustment {
		private final AmountAdjustmentEnum adjustmentType;
		private final MoneyWithParticipantShare amount;
		
		protected AdjustmentImpl(Adjustment.AdjustmentBuilder builder) {
			this.adjustmentType = builder.getAdjustmentType();
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("adjustmentType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustmentType")
		public AmountAdjustmentEnum getAdjustmentType() {
			return adjustmentType;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public MoneyWithParticipantShare getAmount() {
			return amount;
		}
		
		@Override
		public Adjustment build() {
			return this;
		}
		
		@Override
		public Adjustment.AdjustmentBuilder toBuilder() {
			Adjustment.AdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Adjustment.AdjustmentBuilder builder) {
			ofNullable(getAdjustmentType()).ifPresent(builder::setAdjustmentType);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Adjustment _that = getType().cast(o);
		
			if (!Objects.equals(adjustmentType, _that.getAdjustmentType())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustmentType != null ? adjustmentType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Adjustment {" +
				"adjustmentType=" + this.adjustmentType + ", " +
				"amount=" + this.amount +
			'}';
		}
	}

	/*********************** Builder Implementation of Adjustment  ***********************/
	class AdjustmentBuilderImpl implements Adjustment.AdjustmentBuilder {
	
		protected AmountAdjustmentEnum adjustmentType;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder amount;
		
		@Override
		@RosettaAttribute("adjustmentType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("adjustmentType")
		public AmountAdjustmentEnum getAdjustmentType() {
			return adjustmentType;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getAmount() {
			return amount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("adjustmentType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("adjustmentType")
		@Override
		public Adjustment.AdjustmentBuilder setAdjustmentType(AmountAdjustmentEnum _adjustmentType) {
			this.adjustmentType = _adjustmentType == null ? null : _adjustmentType;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public Adjustment.AdjustmentBuilder setAmount(MoneyWithParticipantShare _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@Override
		public Adjustment build() {
			return new Adjustment.AdjustmentImpl(this);
		}
		
		@Override
		public Adjustment.AdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Adjustment.AdjustmentBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustmentType()!=null) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Adjustment.AdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Adjustment.AdjustmentBuilder o = (Adjustment.AdjustmentBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getAdjustmentType(), o.getAdjustmentType(), this::setAdjustmentType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Adjustment _that = getType().cast(o);
		
			if (!Objects.equals(adjustmentType, _that.getAdjustmentType())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustmentType != null ? adjustmentType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustmentBuilder {" +
				"adjustmentType=" + this.adjustmentType + ", " +
				"amount=" + this.amount +
			'}';
		}
	}
}
