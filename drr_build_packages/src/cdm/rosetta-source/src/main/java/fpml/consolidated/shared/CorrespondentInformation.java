package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.CorrespondentInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that describes the information to identify a correspondent bank that will make delivery of the funds on the paying bank's behalf in the country where the payment is to be made.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that describes the information to identify a correspondent bank that will make delivery of the funds on the paying bank's behalf in the country where the payment is to be made.
 *
 */
@RosettaDataType(value="CorrespondentInformation", builder=CorrespondentInformation.CorrespondentInformationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CorrespondentInformation", model="fpml", builder=CorrespondentInformation.CorrespondentInformationBuilderImpl.class, version="2.1.1")
public interface CorrespondentInformation extends RosettaModelObject {

	CorrespondentInformationMeta metaData = new CorrespondentInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A set of unique identifiers for a party, eachone identifying the party within a payment system. The assumption is that each party will not have more than one identifier within the same payment system.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A set of unique identifiers for a party, eachone identifying the party within a payment system. The assumption is that each party will not have more than one identifier within the same payment system.
	 *
	 */
	RoutingIds getRoutingIds();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A set of details that is used to identify a party involved in the routing of a payment when the party does not have a code that identifies it within one of the recognized payment systems.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A set of details that is used to identify a party involved in the routing of a payment when the party does not have a code that identifies it within one of the recognized payment systems.
	 *
	 */
	RoutingExplicitDetails getRoutingExplicitDetails();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A combination of coded payment system identifiers and details for physical addressing for a party involved in the routing of a payment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A combination of coded payment system identifiers and details for physical addressing for a party involved in the routing of a payment.
	 *
	 */
	RoutingIdsAndExplicitDetails getRoutingIdsAndExplicitDetails();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Link to the party acting as correspondent. This element can only appear within the correspondentInformation container element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Link to the party acting as correspondent. This element can only appear within the correspondentInformation container element.
	 *
	 */
	PartyReference getCorrespondentPartyReference();

	/*********************** Build Methods  ***********************/
	CorrespondentInformation build();
	
	CorrespondentInformation.CorrespondentInformationBuilder toBuilder();
	
	static CorrespondentInformation.CorrespondentInformationBuilder builder() {
		return new CorrespondentInformation.CorrespondentInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrespondentInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CorrespondentInformation> getType() {
		return CorrespondentInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.class, getRoutingIds());
		processRosetta(path.newSubPath("routingExplicitDetails"), processor, RoutingExplicitDetails.class, getRoutingExplicitDetails());
		processRosetta(path.newSubPath("routingIdsAndExplicitDetails"), processor, RoutingIdsAndExplicitDetails.class, getRoutingIdsAndExplicitDetails());
		processRosetta(path.newSubPath("correspondentPartyReference"), processor, PartyReference.class, getCorrespondentPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrespondentInformationBuilder extends CorrespondentInformation, RosettaModelObjectBuilder {
		RoutingIds.RoutingIdsBuilder getOrCreateRoutingIds();
		@Override
		RoutingIds.RoutingIdsBuilder getRoutingIds();
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder getOrCreateRoutingExplicitDetails();
		@Override
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder getRoutingExplicitDetails();
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getOrCreateRoutingIdsAndExplicitDetails();
		@Override
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getRoutingIdsAndExplicitDetails();
		PartyReference.PartyReferenceBuilder getOrCreateCorrespondentPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getCorrespondentPartyReference();
		CorrespondentInformation.CorrespondentInformationBuilder setRoutingIds(RoutingIds routingIds);
		CorrespondentInformation.CorrespondentInformationBuilder setRoutingExplicitDetails(RoutingExplicitDetails routingExplicitDetails);
		CorrespondentInformation.CorrespondentInformationBuilder setRoutingIdsAndExplicitDetails(RoutingIdsAndExplicitDetails routingIdsAndExplicitDetails);
		CorrespondentInformation.CorrespondentInformationBuilder setCorrespondentPartyReference(PartyReference correspondentPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.RoutingIdsBuilder.class, getRoutingIds());
			processRosetta(path.newSubPath("routingExplicitDetails"), processor, RoutingExplicitDetails.RoutingExplicitDetailsBuilder.class, getRoutingExplicitDetails());
			processRosetta(path.newSubPath("routingIdsAndExplicitDetails"), processor, RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder.class, getRoutingIdsAndExplicitDetails());
			processRosetta(path.newSubPath("correspondentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getCorrespondentPartyReference());
		}
		

		CorrespondentInformation.CorrespondentInformationBuilder prune();
	}

	/*********************** Immutable Implementation of CorrespondentInformation  ***********************/
	class CorrespondentInformationImpl implements CorrespondentInformation {
		private final RoutingIds routingIds;
		private final RoutingExplicitDetails routingExplicitDetails;
		private final RoutingIdsAndExplicitDetails routingIdsAndExplicitDetails;
		private final PartyReference correspondentPartyReference;
		
		protected CorrespondentInformationImpl(CorrespondentInformation.CorrespondentInformationBuilder builder) {
			this.routingIds = ofNullable(builder.getRoutingIds()).map(f->f.build()).orElse(null);
			this.routingExplicitDetails = ofNullable(builder.getRoutingExplicitDetails()).map(f->f.build()).orElse(null);
			this.routingIdsAndExplicitDetails = ofNullable(builder.getRoutingIdsAndExplicitDetails()).map(f->f.build()).orElse(null);
			this.correspondentPartyReference = ofNullable(builder.getCorrespondentPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("routingIds")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("routingIds")
		public RoutingIds getRoutingIds() {
			return routingIds;
		}
		
		@Override
		@RosettaAttribute("routingExplicitDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("routingExplicitDetails")
		public RoutingExplicitDetails getRoutingExplicitDetails() {
			return routingExplicitDetails;
		}
		
		@Override
		@RosettaAttribute("routingIdsAndExplicitDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("routingIdsAndExplicitDetails")
		public RoutingIdsAndExplicitDetails getRoutingIdsAndExplicitDetails() {
			return routingIdsAndExplicitDetails;
		}
		
		@Override
		@RosettaAttribute("correspondentPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("correspondentPartyReference")
		public PartyReference getCorrespondentPartyReference() {
			return correspondentPartyReference;
		}
		
		@Override
		public CorrespondentInformation build() {
			return this;
		}
		
		@Override
		public CorrespondentInformation.CorrespondentInformationBuilder toBuilder() {
			CorrespondentInformation.CorrespondentInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrespondentInformation.CorrespondentInformationBuilder builder) {
			ofNullable(getRoutingIds()).ifPresent(builder::setRoutingIds);
			ofNullable(getRoutingExplicitDetails()).ifPresent(builder::setRoutingExplicitDetails);
			ofNullable(getRoutingIdsAndExplicitDetails()).ifPresent(builder::setRoutingIdsAndExplicitDetails);
			ofNullable(getCorrespondentPartyReference()).ifPresent(builder::setCorrespondentPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrespondentInformation _that = getType().cast(o);
		
			if (!Objects.equals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingExplicitDetails, _that.getRoutingExplicitDetails())) return false;
			if (!Objects.equals(routingIdsAndExplicitDetails, _that.getRoutingIdsAndExplicitDetails())) return false;
			if (!Objects.equals(correspondentPartyReference, _that.getCorrespondentPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingExplicitDetails != null ? routingExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (routingIdsAndExplicitDetails != null ? routingIdsAndExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (correspondentPartyReference != null ? correspondentPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrespondentInformation {" +
				"routingIds=" + this.routingIds + ", " +
				"routingExplicitDetails=" + this.routingExplicitDetails + ", " +
				"routingIdsAndExplicitDetails=" + this.routingIdsAndExplicitDetails + ", " +
				"correspondentPartyReference=" + this.correspondentPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CorrespondentInformation  ***********************/
	class CorrespondentInformationBuilderImpl implements CorrespondentInformation.CorrespondentInformationBuilder {
	
		protected RoutingIds.RoutingIdsBuilder routingIds;
		protected RoutingExplicitDetails.RoutingExplicitDetailsBuilder routingExplicitDetails;
		protected RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder routingIdsAndExplicitDetails;
		protected PartyReference.PartyReferenceBuilder correspondentPartyReference;
		
		@Override
		@RosettaAttribute("routingIds")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("routingIds")
		public RoutingIds.RoutingIdsBuilder getRoutingIds() {
			return routingIds;
		}
		
		@Override
		public RoutingIds.RoutingIdsBuilder getOrCreateRoutingIds() {
			RoutingIds.RoutingIdsBuilder result;
			if (routingIds!=null) {
				result = routingIds;
			}
			else {
				result = routingIds = RoutingIds.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("routingExplicitDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("routingExplicitDetails")
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder getRoutingExplicitDetails() {
			return routingExplicitDetails;
		}
		
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder getOrCreateRoutingExplicitDetails() {
			RoutingExplicitDetails.RoutingExplicitDetailsBuilder result;
			if (routingExplicitDetails!=null) {
				result = routingExplicitDetails;
			}
			else {
				result = routingExplicitDetails = RoutingExplicitDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("routingIdsAndExplicitDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("routingIdsAndExplicitDetails")
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getRoutingIdsAndExplicitDetails() {
			return routingIdsAndExplicitDetails;
		}
		
		@Override
		public RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getOrCreateRoutingIdsAndExplicitDetails() {
			RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder result;
			if (routingIdsAndExplicitDetails!=null) {
				result = routingIdsAndExplicitDetails;
			}
			else {
				result = routingIdsAndExplicitDetails = RoutingIdsAndExplicitDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correspondentPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("correspondentPartyReference")
		public PartyReference.PartyReferenceBuilder getCorrespondentPartyReference() {
			return correspondentPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateCorrespondentPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (correspondentPartyReference!=null) {
				result = correspondentPartyReference;
			}
			else {
				result = correspondentPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("routingIds")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingIds")
		@Override
		public CorrespondentInformation.CorrespondentInformationBuilder setRoutingIds(RoutingIds _routingIds) {
			this.routingIds = _routingIds == null ? null : _routingIds.toBuilder();
			return this;
		}
		
		@RosettaAttribute("routingExplicitDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingExplicitDetails")
		@Override
		public CorrespondentInformation.CorrespondentInformationBuilder setRoutingExplicitDetails(RoutingExplicitDetails _routingExplicitDetails) {
			this.routingExplicitDetails = _routingExplicitDetails == null ? null : _routingExplicitDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("routingIdsAndExplicitDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingIdsAndExplicitDetails")
		@Override
		public CorrespondentInformation.CorrespondentInformationBuilder setRoutingIdsAndExplicitDetails(RoutingIdsAndExplicitDetails _routingIdsAndExplicitDetails) {
			this.routingIdsAndExplicitDetails = _routingIdsAndExplicitDetails == null ? null : _routingIdsAndExplicitDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correspondentPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correspondentPartyReference")
		@Override
		public CorrespondentInformation.CorrespondentInformationBuilder setCorrespondentPartyReference(PartyReference _correspondentPartyReference) {
			this.correspondentPartyReference = _correspondentPartyReference == null ? null : _correspondentPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public CorrespondentInformation build() {
			return new CorrespondentInformation.CorrespondentInformationImpl(this);
		}
		
		@Override
		public CorrespondentInformation.CorrespondentInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrespondentInformation.CorrespondentInformationBuilder prune() {
			if (routingIds!=null && !routingIds.prune().hasData()) routingIds = null;
			if (routingExplicitDetails!=null && !routingExplicitDetails.prune().hasData()) routingExplicitDetails = null;
			if (routingIdsAndExplicitDetails!=null && !routingIdsAndExplicitDetails.prune().hasData()) routingIdsAndExplicitDetails = null;
			if (correspondentPartyReference!=null && !correspondentPartyReference.prune().hasData()) correspondentPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingIds()!=null && getRoutingIds().hasData()) return true;
			if (getRoutingExplicitDetails()!=null && getRoutingExplicitDetails().hasData()) return true;
			if (getRoutingIdsAndExplicitDetails()!=null && getRoutingIdsAndExplicitDetails().hasData()) return true;
			if (getCorrespondentPartyReference()!=null && getCorrespondentPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrespondentInformation.CorrespondentInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CorrespondentInformation.CorrespondentInformationBuilder o = (CorrespondentInformation.CorrespondentInformationBuilder) other;
			
			merger.mergeRosetta(getRoutingIds(), o.getRoutingIds(), this::setRoutingIds);
			merger.mergeRosetta(getRoutingExplicitDetails(), o.getRoutingExplicitDetails(), this::setRoutingExplicitDetails);
			merger.mergeRosetta(getRoutingIdsAndExplicitDetails(), o.getRoutingIdsAndExplicitDetails(), this::setRoutingIdsAndExplicitDetails);
			merger.mergeRosetta(getCorrespondentPartyReference(), o.getCorrespondentPartyReference(), this::setCorrespondentPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrespondentInformation _that = getType().cast(o);
		
			if (!Objects.equals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingExplicitDetails, _that.getRoutingExplicitDetails())) return false;
			if (!Objects.equals(routingIdsAndExplicitDetails, _that.getRoutingIdsAndExplicitDetails())) return false;
			if (!Objects.equals(correspondentPartyReference, _that.getCorrespondentPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingExplicitDetails != null ? routingExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (routingIdsAndExplicitDetails != null ? routingIdsAndExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (correspondentPartyReference != null ? correspondentPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrespondentInformationBuilder {" +
				"routingIds=" + this.routingIds + ", " +
				"routingExplicitDetails=" + this.routingExplicitDetails + ", " +
				"routingIdsAndExplicitDetails=" + this.routingIdsAndExplicitDetails + ", " +
				"correspondentPartyReference=" + this.correspondentPartyReference +
			'}';
		}
	}
}
