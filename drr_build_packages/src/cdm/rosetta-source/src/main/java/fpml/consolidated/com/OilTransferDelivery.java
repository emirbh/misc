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
import fpml.consolidated.com.meta.OilTransferDeliveryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The physical delivery conditions specific to an oil product delivered by title transfer.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The physical delivery conditions specific to an oil product delivered by title transfer.
 *
 */
@RosettaDataType(value="OilTransferDelivery", builder=OilTransferDelivery.OilTransferDeliveryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OilTransferDelivery", model="fpml", builder=OilTransferDelivery.OilTransferDeliveryBuilderImpl.class, version="2.1.1")
public interface OilTransferDelivery extends RosettaModelObject {

	OilTransferDeliveryMeta metaData = new OilTransferDeliveryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that the oil product will be delivered by title transfer. Should always be set to "true".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates that the oil product will be delivered by title transfer. Should always be set to "true".
	 *
	 */
	Boolean getApplicable();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The location at which the transfer of the title to the commodity takes place.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The location at which the transfer of the title to the commodity takes place.
	 *
	 */
	CommodityDeliveryPoint getDeliveryLocation();

	/*********************** Build Methods  ***********************/
	OilTransferDelivery build();
	
	OilTransferDelivery.OilTransferDeliveryBuilder toBuilder();
	
	static OilTransferDelivery.OilTransferDeliveryBuilder builder() {
		return new OilTransferDelivery.OilTransferDeliveryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OilTransferDelivery> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OilTransferDelivery> getType() {
		return OilTransferDelivery.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processRosetta(path.newSubPath("deliveryLocation"), processor, CommodityDeliveryPoint.class, getDeliveryLocation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OilTransferDeliveryBuilder extends OilTransferDelivery, RosettaModelObjectBuilder {
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateDeliveryLocation();
		@Override
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getDeliveryLocation();
		OilTransferDelivery.OilTransferDeliveryBuilder setApplicable(Boolean applicable);
		OilTransferDelivery.OilTransferDeliveryBuilder setDeliveryLocation(CommodityDeliveryPoint deliveryLocation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processRosetta(path.newSubPath("deliveryLocation"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getDeliveryLocation());
		}
		

		OilTransferDelivery.OilTransferDeliveryBuilder prune();
	}

	/*********************** Immutable Implementation of OilTransferDelivery  ***********************/
	class OilTransferDeliveryImpl implements OilTransferDelivery {
		private final Boolean applicable;
		private final CommodityDeliveryPoint deliveryLocation;
		
		protected OilTransferDeliveryImpl(OilTransferDelivery.OilTransferDeliveryBuilder builder) {
			this.applicable = builder.getApplicable();
			this.deliveryLocation = ofNullable(builder.getDeliveryLocation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("deliveryLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryLocation")
		public CommodityDeliveryPoint getDeliveryLocation() {
			return deliveryLocation;
		}
		
		@Override
		public OilTransferDelivery build() {
			return this;
		}
		
		@Override
		public OilTransferDelivery.OilTransferDeliveryBuilder toBuilder() {
			OilTransferDelivery.OilTransferDeliveryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OilTransferDelivery.OilTransferDeliveryBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getDeliveryLocation()).ifPresent(builder::setDeliveryLocation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilTransferDelivery _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(deliveryLocation, _that.getDeliveryLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (deliveryLocation != null ? deliveryLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilTransferDelivery {" +
				"applicable=" + this.applicable + ", " +
				"deliveryLocation=" + this.deliveryLocation +
			'}';
		}
	}

	/*********************** Builder Implementation of OilTransferDelivery  ***********************/
	class OilTransferDeliveryBuilderImpl implements OilTransferDelivery.OilTransferDeliveryBuilder {
	
		protected Boolean applicable;
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder deliveryLocation;
		
		@Override
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("deliveryLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryLocation")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getDeliveryLocation() {
			return deliveryLocation;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateDeliveryLocation() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (deliveryLocation!=null) {
				result = deliveryLocation;
			}
			else {
				result = deliveryLocation = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicable")
		@Override
		public OilTransferDelivery.OilTransferDeliveryBuilder setApplicable(Boolean _applicable) {
			this.applicable = _applicable == null ? null : _applicable;
			return this;
		}
		
		@RosettaAttribute("deliveryLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryLocation")
		@Override
		public OilTransferDelivery.OilTransferDeliveryBuilder setDeliveryLocation(CommodityDeliveryPoint _deliveryLocation) {
			this.deliveryLocation = _deliveryLocation == null ? null : _deliveryLocation.toBuilder();
			return this;
		}
		
		@Override
		public OilTransferDelivery build() {
			return new OilTransferDelivery.OilTransferDeliveryImpl(this);
		}
		
		@Override
		public OilTransferDelivery.OilTransferDeliveryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilTransferDelivery.OilTransferDeliveryBuilder prune() {
			if (deliveryLocation!=null && !deliveryLocation.prune().hasData()) deliveryLocation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getDeliveryLocation()!=null && getDeliveryLocation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilTransferDelivery.OilTransferDeliveryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OilTransferDelivery.OilTransferDeliveryBuilder o = (OilTransferDelivery.OilTransferDeliveryBuilder) other;
			
			merger.mergeRosetta(getDeliveryLocation(), o.getDeliveryLocation(), this::setDeliveryLocation);
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilTransferDelivery _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(deliveryLocation, _that.getDeliveryLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (deliveryLocation != null ? deliveryLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilTransferDeliveryBuilder {" +
				"applicable=" + this.applicable + ", " +
				"deliveryLocation=" + this.deliveryLocation +
			'}';
		}
	}
}
