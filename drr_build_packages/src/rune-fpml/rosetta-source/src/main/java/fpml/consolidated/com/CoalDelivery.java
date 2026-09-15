package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CoalDeliveryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The physical delivery conditions for coal.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The physical delivery conditions for coal.
 *
 */
@RosettaDataType(value="CoalDelivery", builder=CoalDelivery.CoalDeliveryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CoalDelivery", model="fpml", builder=CoalDelivery.CoalDeliveryBuilderImpl.class, version="2.1.1")
public interface CoalDelivery extends RosettaModelObject {

	CoalDeliveryMeta metaData = new CoalDeliveryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The point at which the Coal Product will be delivered and received.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The point at which the Coal Product will be delivered and received.
	 *
	 */
	CoalDeliveryPoint getDeliveryPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The point at which the Coal Product as a reference to the Source of the Coal Product. This should be a reference to the source element within product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The point at which the Coal Product as a reference to the Source of the Coal Product. This should be a reference to the source element within product.
	 *
	 */
	Boolean getDeliveryAtSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true, indicates that QVA is applicable. If false, indicates that QVA is inapplicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true, indicates that QVA is applicable. If false, indicates that QVA is inapplicable.
	 *
	 */
	Boolean getQuantityVariationAdjustment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The transportation equipment with which the Coal Product will be delivered and received.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The transportation equipment with which the Coal Product will be delivered and received.
	 *
	 */
	CoalTransportationEquipment getTransportationEquipment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies how the risk associated with the delivery is assigned.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies how the risk associated with the delivery is assigned.
	 *
	 */
	CommodityDeliveryRisk getRisk();

	/*********************** Build Methods  ***********************/
	CoalDelivery build();
	
	CoalDelivery.CoalDeliveryBuilder toBuilder();
	
	static CoalDelivery.CoalDeliveryBuilder builder() {
		return new CoalDelivery.CoalDeliveryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalDelivery> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CoalDelivery> getType() {
		return CoalDelivery.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("deliveryPoint"), processor, CoalDeliveryPoint.class, getDeliveryPoint());
		processor.processBasic(path.newSubPath("deliveryAtSource"), Boolean.class, getDeliveryAtSource(), this);
		processor.processBasic(path.newSubPath("quantityVariationAdjustment"), Boolean.class, getQuantityVariationAdjustment(), this);
		processRosetta(path.newSubPath("transportationEquipment"), processor, CoalTransportationEquipment.class, getTransportationEquipment());
		processRosetta(path.newSubPath("risk"), processor, CommodityDeliveryRisk.class, getRisk());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalDeliveryBuilder extends CoalDelivery, RosettaModelObjectBuilder {
		CoalDeliveryPoint.CoalDeliveryPointBuilder getOrCreateDeliveryPoint();
		@Override
		CoalDeliveryPoint.CoalDeliveryPointBuilder getDeliveryPoint();
		CoalTransportationEquipment.CoalTransportationEquipmentBuilder getOrCreateTransportationEquipment();
		@Override
		CoalTransportationEquipment.CoalTransportationEquipmentBuilder getTransportationEquipment();
		CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getOrCreateRisk();
		@Override
		CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getRisk();
		CoalDelivery.CoalDeliveryBuilder setDeliveryPoint(CoalDeliveryPoint deliveryPoint);
		CoalDelivery.CoalDeliveryBuilder setDeliveryAtSource(Boolean deliveryAtSource);
		CoalDelivery.CoalDeliveryBuilder setQuantityVariationAdjustment(Boolean quantityVariationAdjustment);
		CoalDelivery.CoalDeliveryBuilder setTransportationEquipment(CoalTransportationEquipment transportationEquipment);
		CoalDelivery.CoalDeliveryBuilder setRisk(CommodityDeliveryRisk risk);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("deliveryPoint"), processor, CoalDeliveryPoint.CoalDeliveryPointBuilder.class, getDeliveryPoint());
			processor.processBasic(path.newSubPath("deliveryAtSource"), Boolean.class, getDeliveryAtSource(), this);
			processor.processBasic(path.newSubPath("quantityVariationAdjustment"), Boolean.class, getQuantityVariationAdjustment(), this);
			processRosetta(path.newSubPath("transportationEquipment"), processor, CoalTransportationEquipment.CoalTransportationEquipmentBuilder.class, getTransportationEquipment());
			processRosetta(path.newSubPath("risk"), processor, CommodityDeliveryRisk.CommodityDeliveryRiskBuilder.class, getRisk());
		}
		

		CoalDelivery.CoalDeliveryBuilder prune();
	}

	/*********************** Immutable Implementation of CoalDelivery  ***********************/
	class CoalDeliveryImpl implements CoalDelivery {
		private final CoalDeliveryPoint deliveryPoint;
		private final Boolean deliveryAtSource;
		private final Boolean quantityVariationAdjustment;
		private final CoalTransportationEquipment transportationEquipment;
		private final CommodityDeliveryRisk risk;
		
		protected CoalDeliveryImpl(CoalDelivery.CoalDeliveryBuilder builder) {
			this.deliveryPoint = ofNullable(builder.getDeliveryPoint()).map(f->f.build()).orElse(null);
			this.deliveryAtSource = builder.getDeliveryAtSource();
			this.quantityVariationAdjustment = builder.getQuantityVariationAdjustment();
			this.transportationEquipment = ofNullable(builder.getTransportationEquipment()).map(f->f.build()).orElse(null);
			this.risk = ofNullable(builder.getRisk()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPoint")
		public CoalDeliveryPoint getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		@RosettaAttribute("deliveryAtSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryAtSource")
		public Boolean getDeliveryAtSource() {
			return deliveryAtSource;
		}
		
		@Override
		@RosettaAttribute("quantityVariationAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityVariationAdjustment")
		public Boolean getQuantityVariationAdjustment() {
			return quantityVariationAdjustment;
		}
		
		@Override
		@RosettaAttribute("transportationEquipment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transportationEquipment")
		public CoalTransportationEquipment getTransportationEquipment() {
			return transportationEquipment;
		}
		
		@Override
		@RosettaAttribute("risk")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("risk")
		public CommodityDeliveryRisk getRisk() {
			return risk;
		}
		
		@Override
		public CoalDelivery build() {
			return this;
		}
		
		@Override
		public CoalDelivery.CoalDeliveryBuilder toBuilder() {
			CoalDelivery.CoalDeliveryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalDelivery.CoalDeliveryBuilder builder) {
			ofNullable(getDeliveryPoint()).ifPresent(builder::setDeliveryPoint);
			ofNullable(getDeliveryAtSource()).ifPresent(builder::setDeliveryAtSource);
			ofNullable(getQuantityVariationAdjustment()).ifPresent(builder::setQuantityVariationAdjustment);
			ofNullable(getTransportationEquipment()).ifPresent(builder::setTransportationEquipment);
			ofNullable(getRisk()).ifPresent(builder::setRisk);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalDelivery _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(deliveryAtSource, _that.getDeliveryAtSource())) return false;
			if (!Objects.equals(quantityVariationAdjustment, _that.getQuantityVariationAdjustment())) return false;
			if (!Objects.equals(transportationEquipment, _that.getTransportationEquipment())) return false;
			if (!Objects.equals(risk, _that.getRisk())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (deliveryAtSource != null ? deliveryAtSource.hashCode() : 0);
			_result = 31 * _result + (quantityVariationAdjustment != null ? quantityVariationAdjustment.hashCode() : 0);
			_result = 31 * _result + (transportationEquipment != null ? transportationEquipment.hashCode() : 0);
			_result = 31 * _result + (risk != null ? risk.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalDelivery {" +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"deliveryAtSource=" + this.deliveryAtSource + ", " +
				"quantityVariationAdjustment=" + this.quantityVariationAdjustment + ", " +
				"transportationEquipment=" + this.transportationEquipment + ", " +
				"risk=" + this.risk +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalDelivery  ***********************/
	class CoalDeliveryBuilderImpl implements CoalDelivery.CoalDeliveryBuilder {
	
		protected CoalDeliveryPoint.CoalDeliveryPointBuilder deliveryPoint;
		protected Boolean deliveryAtSource;
		protected Boolean quantityVariationAdjustment;
		protected CoalTransportationEquipment.CoalTransportationEquipmentBuilder transportationEquipment;
		protected CommodityDeliveryRisk.CommodityDeliveryRiskBuilder risk;
		
		@Override
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPoint")
		public CoalDeliveryPoint.CoalDeliveryPointBuilder getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		public CoalDeliveryPoint.CoalDeliveryPointBuilder getOrCreateDeliveryPoint() {
			CoalDeliveryPoint.CoalDeliveryPointBuilder result;
			if (deliveryPoint!=null) {
				result = deliveryPoint;
			}
			else {
				result = deliveryPoint = CoalDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryAtSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryAtSource")
		public Boolean getDeliveryAtSource() {
			return deliveryAtSource;
		}
		
		@Override
		@RosettaAttribute("quantityVariationAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityVariationAdjustment")
		public Boolean getQuantityVariationAdjustment() {
			return quantityVariationAdjustment;
		}
		
		@Override
		@RosettaAttribute("transportationEquipment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transportationEquipment")
		public CoalTransportationEquipment.CoalTransportationEquipmentBuilder getTransportationEquipment() {
			return transportationEquipment;
		}
		
		@Override
		public CoalTransportationEquipment.CoalTransportationEquipmentBuilder getOrCreateTransportationEquipment() {
			CoalTransportationEquipment.CoalTransportationEquipmentBuilder result;
			if (transportationEquipment!=null) {
				result = transportationEquipment;
			}
			else {
				result = transportationEquipment = CoalTransportationEquipment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("risk")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("risk")
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getRisk() {
			return risk;
		}
		
		@Override
		public CommodityDeliveryRisk.CommodityDeliveryRiskBuilder getOrCreateRisk() {
			CommodityDeliveryRisk.CommodityDeliveryRiskBuilder result;
			if (risk!=null) {
				result = risk;
			}
			else {
				result = risk = CommodityDeliveryRisk.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPoint")
		@Override
		public CoalDelivery.CoalDeliveryBuilder setDeliveryPoint(CoalDeliveryPoint _deliveryPoint) {
			this.deliveryPoint = _deliveryPoint == null ? null : _deliveryPoint.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryAtSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryAtSource")
		@Override
		public CoalDelivery.CoalDeliveryBuilder setDeliveryAtSource(Boolean _deliveryAtSource) {
			this.deliveryAtSource = _deliveryAtSource == null ? null : _deliveryAtSource;
			return this;
		}
		
		@RosettaAttribute("quantityVariationAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityVariationAdjustment")
		@Override
		public CoalDelivery.CoalDeliveryBuilder setQuantityVariationAdjustment(Boolean _quantityVariationAdjustment) {
			this.quantityVariationAdjustment = _quantityVariationAdjustment == null ? null : _quantityVariationAdjustment;
			return this;
		}
		
		@RosettaAttribute("transportationEquipment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transportationEquipment")
		@Override
		public CoalDelivery.CoalDeliveryBuilder setTransportationEquipment(CoalTransportationEquipment _transportationEquipment) {
			this.transportationEquipment = _transportationEquipment == null ? null : _transportationEquipment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("risk")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("risk")
		@Override
		public CoalDelivery.CoalDeliveryBuilder setRisk(CommodityDeliveryRisk _risk) {
			this.risk = _risk == null ? null : _risk.toBuilder();
			return this;
		}
		
		@Override
		public CoalDelivery build() {
			return new CoalDelivery.CoalDeliveryImpl(this);
		}
		
		@Override
		public CoalDelivery.CoalDeliveryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalDelivery.CoalDeliveryBuilder prune() {
			if (deliveryPoint!=null && !deliveryPoint.prune().hasData()) deliveryPoint = null;
			if (transportationEquipment!=null && !transportationEquipment.prune().hasData()) transportationEquipment = null;
			if (risk!=null && !risk.prune().hasData()) risk = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryPoint()!=null && getDeliveryPoint().hasData()) return true;
			if (getDeliveryAtSource()!=null) return true;
			if (getQuantityVariationAdjustment()!=null) return true;
			if (getTransportationEquipment()!=null && getTransportationEquipment().hasData()) return true;
			if (getRisk()!=null && getRisk().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalDelivery.CoalDeliveryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalDelivery.CoalDeliveryBuilder o = (CoalDelivery.CoalDeliveryBuilder) other;
			
			merger.mergeRosetta(getDeliveryPoint(), o.getDeliveryPoint(), this::setDeliveryPoint);
			merger.mergeRosetta(getTransportationEquipment(), o.getTransportationEquipment(), this::setTransportationEquipment);
			merger.mergeRosetta(getRisk(), o.getRisk(), this::setRisk);
			
			merger.mergeBasic(getDeliveryAtSource(), o.getDeliveryAtSource(), this::setDeliveryAtSource);
			merger.mergeBasic(getQuantityVariationAdjustment(), o.getQuantityVariationAdjustment(), this::setQuantityVariationAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalDelivery _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(deliveryAtSource, _that.getDeliveryAtSource())) return false;
			if (!Objects.equals(quantityVariationAdjustment, _that.getQuantityVariationAdjustment())) return false;
			if (!Objects.equals(transportationEquipment, _that.getTransportationEquipment())) return false;
			if (!Objects.equals(risk, _that.getRisk())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (deliveryAtSource != null ? deliveryAtSource.hashCode() : 0);
			_result = 31 * _result + (quantityVariationAdjustment != null ? quantityVariationAdjustment.hashCode() : 0);
			_result = 31 * _result + (transportationEquipment != null ? transportationEquipment.hashCode() : 0);
			_result = 31 * _result + (risk != null ? risk.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalDeliveryBuilder {" +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"deliveryAtSource=" + this.deliveryAtSource + ", " +
				"quantityVariationAdjustment=" + this.quantityVariationAdjustment + ", " +
				"transportationEquipment=" + this.transportationEquipment + ", " +
				"risk=" + this.risk +
			'}';
		}
	}
}
