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
import fpml.consolidated.com.meta.ElectricityDeliveryMeta;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The physical delivery conditions for electricity.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The physical delivery conditions for electricity.
 *
 */
@RosettaDataType(value="ElectricityDelivery", builder=ElectricityDelivery.ElectricityDeliveryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ElectricityDelivery", model="fpml", builder=ElectricityDelivery.ElectricityDeliveryBuilderImpl.class, version="2.1.1")
public interface ElectricityDelivery extends RosettaModelObject {

	ElectricityDeliveryMeta metaData = new ElectricityDeliveryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The point at which delivery of the electricity will occur.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The point at which delivery of the electricity will occur.
	 *
	 */
	ElectricityDeliveryPoint getDeliveryPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the under what conditions the Parties' delivery obligations apply.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the under what conditions the Parties' delivery obligations apply.
	 *
	 */
	ElectricityDeliveryType getDeliveryType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that the performance of the buyer or seller shall be excused (under the conditions specified) if transmission of the elctricity is unavailable or interrupted.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates that the performance of the buyer or seller shall be excused (under the conditions specified) if transmission of the elctricity is unavailable or interrupted.
	 *
	 */
	ElectricityTransmissionContingency getTransmissionContingency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identification of the border(s) or border point(s) of a transportation contract.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identification of the border(s) or border point(s) of a transportation contract.
	 *
	 */
	InterconnectionPoint getInterconnectionPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The zone covering potential delivery points for the electricity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The zone covering potential delivery points for the electricity.
	 *
	 */
	CommodityDeliveryPoint getDeliveryZone();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the party able to decide which delivery point within the deliveryPoint is used for delivery. For EEI transactions, this should reference the seller of the electricity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the party able to decide which delivery point within the deliveryPoint is used for delivery. For EEI transactions, this should reference the seller of the electricity.
	 *
	 */
	PartyReference getElectingPartyReference();

	/*********************** Build Methods  ***********************/
	ElectricityDelivery build();
	
	ElectricityDelivery.ElectricityDeliveryBuilder toBuilder();
	
	static ElectricityDelivery.ElectricityDeliveryBuilder builder() {
		return new ElectricityDelivery.ElectricityDeliveryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityDelivery> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ElectricityDelivery> getType() {
		return ElectricityDelivery.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("deliveryPoint"), processor, ElectricityDeliveryPoint.class, getDeliveryPoint());
		processRosetta(path.newSubPath("deliveryType"), processor, ElectricityDeliveryType.class, getDeliveryType());
		processRosetta(path.newSubPath("transmissionContingency"), processor, ElectricityTransmissionContingency.class, getTransmissionContingency());
		processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.class, getInterconnectionPoint());
		processRosetta(path.newSubPath("deliveryZone"), processor, CommodityDeliveryPoint.class, getDeliveryZone());
		processRosetta(path.newSubPath("electingPartyReference"), processor, PartyReference.class, getElectingPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityDeliveryBuilder extends ElectricityDelivery, RosettaModelObjectBuilder {
		ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder getOrCreateDeliveryPoint();
		@Override
		ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder getDeliveryPoint();
		ElectricityDeliveryType.ElectricityDeliveryTypeBuilder getOrCreateDeliveryType();
		@Override
		ElectricityDeliveryType.ElectricityDeliveryTypeBuilder getDeliveryType();
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder getOrCreateTransmissionContingency();
		@Override
		ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder getTransmissionContingency();
		InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint();
		@Override
		InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint();
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateDeliveryZone();
		@Override
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getDeliveryZone();
		PartyReference.PartyReferenceBuilder getOrCreateElectingPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getElectingPartyReference();
		ElectricityDelivery.ElectricityDeliveryBuilder setDeliveryPoint(ElectricityDeliveryPoint deliveryPoint);
		ElectricityDelivery.ElectricityDeliveryBuilder setDeliveryType(ElectricityDeliveryType deliveryType);
		ElectricityDelivery.ElectricityDeliveryBuilder setTransmissionContingency(ElectricityTransmissionContingency transmissionContingency);
		ElectricityDelivery.ElectricityDeliveryBuilder setInterconnectionPoint(InterconnectionPoint interconnectionPoint);
		ElectricityDelivery.ElectricityDeliveryBuilder setDeliveryZone(CommodityDeliveryPoint deliveryZone);
		ElectricityDelivery.ElectricityDeliveryBuilder setElectingPartyReference(PartyReference electingPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("deliveryPoint"), processor, ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder.class, getDeliveryPoint());
			processRosetta(path.newSubPath("deliveryType"), processor, ElectricityDeliveryType.ElectricityDeliveryTypeBuilder.class, getDeliveryType());
			processRosetta(path.newSubPath("transmissionContingency"), processor, ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder.class, getTransmissionContingency());
			processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.InterconnectionPointBuilder.class, getInterconnectionPoint());
			processRosetta(path.newSubPath("deliveryZone"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getDeliveryZone());
			processRosetta(path.newSubPath("electingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getElectingPartyReference());
		}
		

		ElectricityDelivery.ElectricityDeliveryBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityDelivery  ***********************/
	class ElectricityDeliveryImpl implements ElectricityDelivery {
		private final ElectricityDeliveryPoint deliveryPoint;
		private final ElectricityDeliveryType deliveryType;
		private final ElectricityTransmissionContingency transmissionContingency;
		private final InterconnectionPoint interconnectionPoint;
		private final CommodityDeliveryPoint deliveryZone;
		private final PartyReference electingPartyReference;
		
		protected ElectricityDeliveryImpl(ElectricityDelivery.ElectricityDeliveryBuilder builder) {
			this.deliveryPoint = ofNullable(builder.getDeliveryPoint()).map(f->f.build()).orElse(null);
			this.deliveryType = ofNullable(builder.getDeliveryType()).map(f->f.build()).orElse(null);
			this.transmissionContingency = ofNullable(builder.getTransmissionContingency()).map(f->f.build()).orElse(null);
			this.interconnectionPoint = ofNullable(builder.getInterconnectionPoint()).map(f->f.build()).orElse(null);
			this.deliveryZone = ofNullable(builder.getDeliveryZone()).map(f->f.build()).orElse(null);
			this.electingPartyReference = ofNullable(builder.getElectingPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPoint")
		public ElectricityDeliveryPoint getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryType")
		public ElectricityDeliveryType getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("transmissionContingency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transmissionContingency")
		public ElectricityTransmissionContingency getTransmissionContingency() {
			return transmissionContingency;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interconnectionPoint")
		public InterconnectionPoint getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		@RosettaAttribute("deliveryZone")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryZone")
		public CommodityDeliveryPoint getDeliveryZone() {
			return deliveryZone;
		}
		
		@Override
		@RosettaAttribute("electingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("electingPartyReference")
		public PartyReference getElectingPartyReference() {
			return electingPartyReference;
		}
		
		@Override
		public ElectricityDelivery build() {
			return this;
		}
		
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder toBuilder() {
			ElectricityDelivery.ElectricityDeliveryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityDelivery.ElectricityDeliveryBuilder builder) {
			ofNullable(getDeliveryPoint()).ifPresent(builder::setDeliveryPoint);
			ofNullable(getDeliveryType()).ifPresent(builder::setDeliveryType);
			ofNullable(getTransmissionContingency()).ifPresent(builder::setTransmissionContingency);
			ofNullable(getInterconnectionPoint()).ifPresent(builder::setInterconnectionPoint);
			ofNullable(getDeliveryZone()).ifPresent(builder::setDeliveryZone);
			ofNullable(getElectingPartyReference()).ifPresent(builder::setElectingPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDelivery _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(transmissionContingency, _that.getTransmissionContingency())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			if (!Objects.equals(deliveryZone, _that.getDeliveryZone())) return false;
			if (!Objects.equals(electingPartyReference, _that.getElectingPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.hashCode() : 0);
			_result = 31 * _result + (transmissionContingency != null ? transmissionContingency.hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			_result = 31 * _result + (deliveryZone != null ? deliveryZone.hashCode() : 0);
			_result = 31 * _result + (electingPartyReference != null ? electingPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDelivery {" +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"transmissionContingency=" + this.transmissionContingency + ", " +
				"interconnectionPoint=" + this.interconnectionPoint + ", " +
				"deliveryZone=" + this.deliveryZone + ", " +
				"electingPartyReference=" + this.electingPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityDelivery  ***********************/
	class ElectricityDeliveryBuilderImpl implements ElectricityDelivery.ElectricityDeliveryBuilder {
	
		protected ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder deliveryPoint;
		protected ElectricityDeliveryType.ElectricityDeliveryTypeBuilder deliveryType;
		protected ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder transmissionContingency;
		protected InterconnectionPoint.InterconnectionPointBuilder interconnectionPoint;
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder deliveryZone;
		protected PartyReference.PartyReferenceBuilder electingPartyReference;
		
		@Override
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPoint")
		public ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		public ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder getOrCreateDeliveryPoint() {
			ElectricityDeliveryPoint.ElectricityDeliveryPointBuilder result;
			if (deliveryPoint!=null) {
				result = deliveryPoint;
			}
			else {
				result = deliveryPoint = ElectricityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryType")
		public ElectricityDeliveryType.ElectricityDeliveryTypeBuilder getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		public ElectricityDeliveryType.ElectricityDeliveryTypeBuilder getOrCreateDeliveryType() {
			ElectricityDeliveryType.ElectricityDeliveryTypeBuilder result;
			if (deliveryType!=null) {
				result = deliveryType;
			}
			else {
				result = deliveryType = ElectricityDeliveryType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transmissionContingency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transmissionContingency")
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder getTransmissionContingency() {
			return transmissionContingency;
		}
		
		@Override
		public ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder getOrCreateTransmissionContingency() {
			ElectricityTransmissionContingency.ElectricityTransmissionContingencyBuilder result;
			if (transmissionContingency!=null) {
				result = transmissionContingency;
			}
			else {
				result = transmissionContingency = ElectricityTransmissionContingency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interconnectionPoint")
		public InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		public InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint() {
			InterconnectionPoint.InterconnectionPointBuilder result;
			if (interconnectionPoint!=null) {
				result = interconnectionPoint;
			}
			else {
				result = interconnectionPoint = InterconnectionPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryZone")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryZone")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getDeliveryZone() {
			return deliveryZone;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateDeliveryZone() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (deliveryZone!=null) {
				result = deliveryZone;
			}
			else {
				result = deliveryZone = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("electingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("electingPartyReference")
		public PartyReference.PartyReferenceBuilder getElectingPartyReference() {
			return electingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateElectingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (electingPartyReference!=null) {
				result = electingPartyReference;
			}
			else {
				result = electingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPoint")
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder setDeliveryPoint(ElectricityDeliveryPoint _deliveryPoint) {
			this.deliveryPoint = _deliveryPoint == null ? null : _deliveryPoint.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder setDeliveryType(ElectricityDeliveryType _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("transmissionContingency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transmissionContingency")
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder setTransmissionContingency(ElectricityTransmissionContingency _transmissionContingency) {
			this.transmissionContingency = _transmissionContingency == null ? null : _transmissionContingency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interconnectionPoint")
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder setInterconnectionPoint(InterconnectionPoint _interconnectionPoint) {
			this.interconnectionPoint = _interconnectionPoint == null ? null : _interconnectionPoint.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryZone")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryZone")
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder setDeliveryZone(CommodityDeliveryPoint _deliveryZone) {
			this.deliveryZone = _deliveryZone == null ? null : _deliveryZone.toBuilder();
			return this;
		}
		
		@RosettaAttribute("electingPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("electingPartyReference")
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder setElectingPartyReference(PartyReference _electingPartyReference) {
			this.electingPartyReference = _electingPartyReference == null ? null : _electingPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public ElectricityDelivery build() {
			return new ElectricityDelivery.ElectricityDeliveryImpl(this);
		}
		
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder prune() {
			if (deliveryPoint!=null && !deliveryPoint.prune().hasData()) deliveryPoint = null;
			if (deliveryType!=null && !deliveryType.prune().hasData()) deliveryType = null;
			if (transmissionContingency!=null && !transmissionContingency.prune().hasData()) transmissionContingency = null;
			if (interconnectionPoint!=null && !interconnectionPoint.prune().hasData()) interconnectionPoint = null;
			if (deliveryZone!=null && !deliveryZone.prune().hasData()) deliveryZone = null;
			if (electingPartyReference!=null && !electingPartyReference.prune().hasData()) electingPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryPoint()!=null && getDeliveryPoint().hasData()) return true;
			if (getDeliveryType()!=null && getDeliveryType().hasData()) return true;
			if (getTransmissionContingency()!=null && getTransmissionContingency().hasData()) return true;
			if (getInterconnectionPoint()!=null && getInterconnectionPoint().hasData()) return true;
			if (getDeliveryZone()!=null && getDeliveryZone().hasData()) return true;
			if (getElectingPartyReference()!=null && getElectingPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityDelivery.ElectricityDeliveryBuilder o = (ElectricityDelivery.ElectricityDeliveryBuilder) other;
			
			merger.mergeRosetta(getDeliveryPoint(), o.getDeliveryPoint(), this::setDeliveryPoint);
			merger.mergeRosetta(getDeliveryType(), o.getDeliveryType(), this::setDeliveryType);
			merger.mergeRosetta(getTransmissionContingency(), o.getTransmissionContingency(), this::setTransmissionContingency);
			merger.mergeRosetta(getInterconnectionPoint(), o.getInterconnectionPoint(), this::setInterconnectionPoint);
			merger.mergeRosetta(getDeliveryZone(), o.getDeliveryZone(), this::setDeliveryZone);
			merger.mergeRosetta(getElectingPartyReference(), o.getElectingPartyReference(), this::setElectingPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDelivery _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(transmissionContingency, _that.getTransmissionContingency())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			if (!Objects.equals(deliveryZone, _that.getDeliveryZone())) return false;
			if (!Objects.equals(electingPartyReference, _that.getElectingPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.hashCode() : 0);
			_result = 31 * _result + (transmissionContingency != null ? transmissionContingency.hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			_result = 31 * _result + (deliveryZone != null ? deliveryZone.hashCode() : 0);
			_result = 31 * _result + (electingPartyReference != null ? electingPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliveryBuilder {" +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"transmissionContingency=" + this.transmissionContingency + ", " +
				"interconnectionPoint=" + this.interconnectionPoint + ", " +
				"deliveryZone=" + this.deliveryZone + ", " +
				"electingPartyReference=" + this.electingPartyReference +
			'}';
		}
	}
}
