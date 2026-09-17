package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.InterestAmountMeta;
import cdm.product.collateral.DeliveryAmount;
import cdm.product.collateral.ReturnAmount;
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
 * A class to specify the application of Interest Amount with respect to the Delivery Amount and the Return Amount.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(n)(ii)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="InterestAmount", builder=InterestAmount.InterestAmountBuilderImpl.class, version="6.23.0")
@RuneDataType(value="InterestAmount", model="cdm", builder=InterestAmount.InterestAmountBuilderImpl.class, version="6.23.0")
public interface InterestAmount extends RosettaModelObject {

	InterestAmountMeta metaData = new InterestAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The application of Interest Amount with respect the Return Amount.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(n)(ii)"
	 *
	 * Provision 
	 *
	 */
	ReturnAmount getReturnAmount();
	/**
	 * The application of Interest Amount with respect the Delivery Amount.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
	 * paragraph "13 General Principles" * clause "(n)(ii)"
	 *
	 * Provision 
	 *
	 */
	DeliveryAmount getDeliveryAmount();

	/*********************** Build Methods  ***********************/
	InterestAmount build();
	
	InterestAmount.InterestAmountBuilder toBuilder();
	
	static InterestAmount.InterestAmountBuilder builder() {
		return new InterestAmount.InterestAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestAmount> getType() {
		return InterestAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("returnAmount"), processor, ReturnAmount.class, getReturnAmount());
		processRosetta(path.newSubPath("deliveryAmount"), processor, DeliveryAmount.class, getDeliveryAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestAmountBuilder extends InterestAmount, RosettaModelObjectBuilder {
		ReturnAmount.ReturnAmountBuilder getOrCreateReturnAmount();
		@Override
		ReturnAmount.ReturnAmountBuilder getReturnAmount();
		DeliveryAmount.DeliveryAmountBuilder getOrCreateDeliveryAmount();
		@Override
		DeliveryAmount.DeliveryAmountBuilder getDeliveryAmount();
		InterestAmount.InterestAmountBuilder setReturnAmount(ReturnAmount returnAmount);
		InterestAmount.InterestAmountBuilder setDeliveryAmount(DeliveryAmount deliveryAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("returnAmount"), processor, ReturnAmount.ReturnAmountBuilder.class, getReturnAmount());
			processRosetta(path.newSubPath("deliveryAmount"), processor, DeliveryAmount.DeliveryAmountBuilder.class, getDeliveryAmount());
		}
		

		InterestAmount.InterestAmountBuilder prune();
	}

	/*********************** Immutable Implementation of InterestAmount  ***********************/
	class InterestAmountImpl implements InterestAmount {
		private final ReturnAmount returnAmount;
		private final DeliveryAmount deliveryAmount;
		
		protected InterestAmountImpl(InterestAmount.InterestAmountBuilder builder) {
			this.returnAmount = ofNullable(builder.getReturnAmount()).map(f->f.build()).orElse(null);
			this.deliveryAmount = ofNullable(builder.getDeliveryAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("returnAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("returnAmount")
		public ReturnAmount getReturnAmount() {
			return returnAmount;
		}
		
		@Override
		@RosettaAttribute("deliveryAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryAmount")
		public DeliveryAmount getDeliveryAmount() {
			return deliveryAmount;
		}
		
		@Override
		public InterestAmount build() {
			return this;
		}
		
		@Override
		public InterestAmount.InterestAmountBuilder toBuilder() {
			InterestAmount.InterestAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestAmount.InterestAmountBuilder builder) {
			ofNullable(getReturnAmount()).ifPresent(builder::setReturnAmount);
			ofNullable(getDeliveryAmount()).ifPresent(builder::setDeliveryAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAmount _that = getType().cast(o);
		
			if (!Objects.equals(returnAmount, _that.getReturnAmount())) return false;
			if (!Objects.equals(deliveryAmount, _that.getDeliveryAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnAmount != null ? returnAmount.hashCode() : 0);
			_result = 31 * _result + (deliveryAmount != null ? deliveryAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAmount {" +
				"returnAmount=" + this.returnAmount + ", " +
				"deliveryAmount=" + this.deliveryAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestAmount  ***********************/
	class InterestAmountBuilderImpl implements InterestAmount.InterestAmountBuilder {
	
		protected ReturnAmount.ReturnAmountBuilder returnAmount;
		protected DeliveryAmount.DeliveryAmountBuilder deliveryAmount;
		
		@Override
		@RosettaAttribute("returnAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("returnAmount")
		public ReturnAmount.ReturnAmountBuilder getReturnAmount() {
			return returnAmount;
		}
		
		@Override
		public ReturnAmount.ReturnAmountBuilder getOrCreateReturnAmount() {
			ReturnAmount.ReturnAmountBuilder result;
			if (returnAmount!=null) {
				result = returnAmount;
			}
			else {
				result = returnAmount = ReturnAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryAmount")
		public DeliveryAmount.DeliveryAmountBuilder getDeliveryAmount() {
			return deliveryAmount;
		}
		
		@Override
		public DeliveryAmount.DeliveryAmountBuilder getOrCreateDeliveryAmount() {
			DeliveryAmount.DeliveryAmountBuilder result;
			if (deliveryAmount!=null) {
				result = deliveryAmount;
			}
			else {
				result = deliveryAmount = DeliveryAmount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("returnAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("returnAmount")
		@Override
		public InterestAmount.InterestAmountBuilder setReturnAmount(ReturnAmount _returnAmount) {
			this.returnAmount = _returnAmount == null ? null : _returnAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("deliveryAmount")
		@Override
		public InterestAmount.InterestAmountBuilder setDeliveryAmount(DeliveryAmount _deliveryAmount) {
			this.deliveryAmount = _deliveryAmount == null ? null : _deliveryAmount.toBuilder();
			return this;
		}
		
		@Override
		public InterestAmount build() {
			return new InterestAmount.InterestAmountImpl(this);
		}
		
		@Override
		public InterestAmount.InterestAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAmount.InterestAmountBuilder prune() {
			if (returnAmount!=null && !returnAmount.prune().hasData()) returnAmount = null;
			if (deliveryAmount!=null && !deliveryAmount.prune().hasData()) deliveryAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReturnAmount()!=null && getReturnAmount().hasData()) return true;
			if (getDeliveryAmount()!=null && getDeliveryAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAmount.InterestAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestAmount.InterestAmountBuilder o = (InterestAmount.InterestAmountBuilder) other;
			
			merger.mergeRosetta(getReturnAmount(), o.getReturnAmount(), this::setReturnAmount);
			merger.mergeRosetta(getDeliveryAmount(), o.getDeliveryAmount(), this::setDeliveryAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAmount _that = getType().cast(o);
		
			if (!Objects.equals(returnAmount, _that.getReturnAmount())) return false;
			if (!Objects.equals(deliveryAmount, _that.getDeliveryAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnAmount != null ? returnAmount.hashCode() : 0);
			_result = 31 * _result + (deliveryAmount != null ? deliveryAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAmountBuilder {" +
				"returnAmount=" + this.returnAmount + ", " +
				"deliveryAmount=" + this.deliveryAmount +
			'}';
		}
	}
}
