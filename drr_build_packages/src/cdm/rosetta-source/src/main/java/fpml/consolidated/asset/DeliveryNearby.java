package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.DeliveryNearbyMeta;
import fpml.consolidated.fpmlenum.DeliveryNearbyTypeEnum;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defines nearest Delivery Date of the underlying Commodity of expiration of the futures contract.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defines nearest Delivery Date of the underlying Commodity of expiration of the futures contract.
 *
 */
@RosettaDataType(value="DeliveryNearby", builder=DeliveryNearby.DeliveryNearbyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DeliveryNearby", model="fpml", builder=DeliveryNearby.DeliveryNearbyBuilderImpl.class, version="2.1.1")
public interface DeliveryNearby extends RosettaModelObject {

	DeliveryNearbyMeta metaData = new DeliveryNearbyMeta();

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
	 * Provision A time multiplier, e.g. 1, 2 or 3 etc. used in defining Delivery Nearby date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A time multiplier, e.g. 1, 2 or 3 etc. used in defining Delivery Nearby date.
	 *
	 */
	Integer getDeliveryNearbyMultiplier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines a type of the delivery nearby qualifier, expect to be used in conjunction with a delivery nearby multiplier, e.g. 1NearByMonth, 1NearbyWeek, etc. If 'CalculationPeriod' is used, the delivery nearby multiplier is expected to be '0'. To represent 'Spot', the value of the delivery nearby type should be 'NearbyMonth' and the delivery period multiplier should be set to '0' (zero).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines a type of the delivery nearby qualifier, expect to be used in conjunction with a delivery nearby multiplier, e.g. 1NearByMonth, 1NearbyWeek, etc. If 'CalculationPeriod' is used, the delivery nearby multiplier is expected to be '0'. To represent 'Spot', the value of the delivery nearby type should be 'NearbyMonth' and the delivery period multiplier should be set to '0' (zero).
	 *
	 */
	DeliveryNearbyTypeEnum getDeliveryNearbyType();

	/*********************** Build Methods  ***********************/
	DeliveryNearby build();
	
	DeliveryNearby.DeliveryNearbyBuilder toBuilder();
	
	static DeliveryNearby.DeliveryNearbyBuilder builder() {
		return new DeliveryNearby.DeliveryNearbyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DeliveryNearby> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DeliveryNearby> getType() {
		return DeliveryNearby.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("deliveryNearbyMultiplier"), Integer.class, getDeliveryNearbyMultiplier(), this);
		processor.processBasic(path.newSubPath("deliveryNearbyType"), DeliveryNearbyTypeEnum.class, getDeliveryNearbyType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DeliveryNearbyBuilder extends DeliveryNearby, RosettaModelObjectBuilder {
		DeliveryNearby.DeliveryNearbyBuilder setId(String id);
		DeliveryNearby.DeliveryNearbyBuilder setDeliveryNearbyMultiplier(Integer deliveryNearbyMultiplier);
		DeliveryNearby.DeliveryNearbyBuilder setDeliveryNearbyType(DeliveryNearbyTypeEnum deliveryNearbyType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("deliveryNearbyMultiplier"), Integer.class, getDeliveryNearbyMultiplier(), this);
			processor.processBasic(path.newSubPath("deliveryNearbyType"), DeliveryNearbyTypeEnum.class, getDeliveryNearbyType(), this);
		}
		

		DeliveryNearby.DeliveryNearbyBuilder prune();
	}

	/*********************** Immutable Implementation of DeliveryNearby  ***********************/
	class DeliveryNearbyImpl implements DeliveryNearby {
		private final String id;
		private final Integer deliveryNearbyMultiplier;
		private final DeliveryNearbyTypeEnum deliveryNearbyType;
		
		protected DeliveryNearbyImpl(DeliveryNearby.DeliveryNearbyBuilder builder) {
			this.id = builder.getId();
			this.deliveryNearbyMultiplier = builder.getDeliveryNearbyMultiplier();
			this.deliveryNearbyType = builder.getDeliveryNearbyType();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("deliveryNearbyMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryNearbyMultiplier")
		public Integer getDeliveryNearbyMultiplier() {
			return deliveryNearbyMultiplier;
		}
		
		@Override
		@RosettaAttribute("deliveryNearbyType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryNearbyType")
		public DeliveryNearbyTypeEnum getDeliveryNearbyType() {
			return deliveryNearbyType;
		}
		
		@Override
		public DeliveryNearby build() {
			return this;
		}
		
		@Override
		public DeliveryNearby.DeliveryNearbyBuilder toBuilder() {
			DeliveryNearby.DeliveryNearbyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeliveryNearby.DeliveryNearbyBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getDeliveryNearbyMultiplier()).ifPresent(builder::setDeliveryNearbyMultiplier);
			ofNullable(getDeliveryNearbyType()).ifPresent(builder::setDeliveryNearbyType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeliveryNearby _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(deliveryNearbyMultiplier, _that.getDeliveryNearbyMultiplier())) return false;
			if (!Objects.equals(deliveryNearbyType, _that.getDeliveryNearbyType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (deliveryNearbyMultiplier != null ? deliveryNearbyMultiplier.hashCode() : 0);
			_result = 31 * _result + (deliveryNearbyType != null ? deliveryNearbyType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeliveryNearby {" +
				"id=" + this.id + ", " +
				"deliveryNearbyMultiplier=" + this.deliveryNearbyMultiplier + ", " +
				"deliveryNearbyType=" + this.deliveryNearbyType +
			'}';
		}
	}

	/*********************** Builder Implementation of DeliveryNearby  ***********************/
	class DeliveryNearbyBuilderImpl implements DeliveryNearby.DeliveryNearbyBuilder {
	
		protected String id;
		protected Integer deliveryNearbyMultiplier;
		protected DeliveryNearbyTypeEnum deliveryNearbyType;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("deliveryNearbyMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryNearbyMultiplier")
		public Integer getDeliveryNearbyMultiplier() {
			return deliveryNearbyMultiplier;
		}
		
		@Override
		@RosettaAttribute("deliveryNearbyType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryNearbyType")
		public DeliveryNearbyTypeEnum getDeliveryNearbyType() {
			return deliveryNearbyType;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DeliveryNearby.DeliveryNearbyBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("deliveryNearbyMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryNearbyMultiplier")
		@Override
		public DeliveryNearby.DeliveryNearbyBuilder setDeliveryNearbyMultiplier(Integer _deliveryNearbyMultiplier) {
			this.deliveryNearbyMultiplier = _deliveryNearbyMultiplier == null ? null : _deliveryNearbyMultiplier;
			return this;
		}
		
		@RosettaAttribute("deliveryNearbyType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryNearbyType")
		@Override
		public DeliveryNearby.DeliveryNearbyBuilder setDeliveryNearbyType(DeliveryNearbyTypeEnum _deliveryNearbyType) {
			this.deliveryNearbyType = _deliveryNearbyType == null ? null : _deliveryNearbyType;
			return this;
		}
		
		@Override
		public DeliveryNearby build() {
			return new DeliveryNearby.DeliveryNearbyImpl(this);
		}
		
		@Override
		public DeliveryNearby.DeliveryNearbyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeliveryNearby.DeliveryNearbyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getDeliveryNearbyMultiplier()!=null) return true;
			if (getDeliveryNearbyType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeliveryNearby.DeliveryNearbyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DeliveryNearby.DeliveryNearbyBuilder o = (DeliveryNearby.DeliveryNearbyBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getDeliveryNearbyMultiplier(), o.getDeliveryNearbyMultiplier(), this::setDeliveryNearbyMultiplier);
			merger.mergeBasic(getDeliveryNearbyType(), o.getDeliveryNearbyType(), this::setDeliveryNearbyType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeliveryNearby _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(deliveryNearbyMultiplier, _that.getDeliveryNearbyMultiplier())) return false;
			if (!Objects.equals(deliveryNearbyType, _that.getDeliveryNearbyType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (deliveryNearbyMultiplier != null ? deliveryNearbyMultiplier.hashCode() : 0);
			_result = 31 * _result + (deliveryNearbyType != null ? deliveryNearbyType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeliveryNearbyBuilder {" +
				"id=" + this.id + ", " +
				"deliveryNearbyMultiplier=" + this.deliveryNearbyMultiplier + ", " +
				"deliveryNearbyType=" + this.deliveryNearbyType +
			'}';
		}
	}
}
