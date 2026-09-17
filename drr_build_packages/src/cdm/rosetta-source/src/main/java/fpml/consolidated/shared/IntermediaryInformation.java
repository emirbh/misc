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
import fpml.consolidated.shared.meta.IntermediaryInformationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that describes the information to identify an intermediary through which payment will be made by the correspondent bank to the ultimate beneficiary of the funds.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that describes the information to identify an intermediary through which payment will be made by the correspondent bank to the ultimate beneficiary of the funds.
 *
 */
@RosettaDataType(value="IntermediaryInformation", builder=IntermediaryInformation.IntermediaryInformationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IntermediaryInformation", model="fpml", builder=IntermediaryInformation.IntermediaryInformationBuilderImpl.class, version="2.1.1")
public interface IntermediaryInformation extends RosettaModelObject {

	IntermediaryInformationMeta metaData = new IntermediaryInformationMeta();

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
	 * Provision A sequence number that gives the position of the current intermediary in the chain of payment intermediaries. The assumed domain value set is an ascending sequence of integers starting from 1.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A sequence number that gives the position of the current intermediary in the chain of payment intermediaries. The assumed domain value set is an ascending sequence of integers starting from 1.
	 *
	 */
	Integer getIntermediarySequenceNumber();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to the party acting as intermediary.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the party acting as intermediary.
	 *
	 */
	PartyReference getIntermediaryPartyReference();

	/*********************** Build Methods  ***********************/
	IntermediaryInformation build();
	
	IntermediaryInformation.IntermediaryInformationBuilder toBuilder();
	
	static IntermediaryInformation.IntermediaryInformationBuilder builder() {
		return new IntermediaryInformation.IntermediaryInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IntermediaryInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IntermediaryInformation> getType() {
		return IntermediaryInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.class, getRoutingIds());
		processRosetta(path.newSubPath("routingExplicitDetails"), processor, RoutingExplicitDetails.class, getRoutingExplicitDetails());
		processRosetta(path.newSubPath("routingIdsAndExplicitDetails"), processor, RoutingIdsAndExplicitDetails.class, getRoutingIdsAndExplicitDetails());
		processor.processBasic(path.newSubPath("intermediarySequenceNumber"), Integer.class, getIntermediarySequenceNumber(), this);
		processRosetta(path.newSubPath("intermediaryPartyReference"), processor, PartyReference.class, getIntermediaryPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IntermediaryInformationBuilder extends IntermediaryInformation, RosettaModelObjectBuilder {
		RoutingIds.RoutingIdsBuilder getOrCreateRoutingIds();
		@Override
		RoutingIds.RoutingIdsBuilder getRoutingIds();
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder getOrCreateRoutingExplicitDetails();
		@Override
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder getRoutingExplicitDetails();
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getOrCreateRoutingIdsAndExplicitDetails();
		@Override
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getRoutingIdsAndExplicitDetails();
		PartyReference.PartyReferenceBuilder getOrCreateIntermediaryPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getIntermediaryPartyReference();
		IntermediaryInformation.IntermediaryInformationBuilder setRoutingIds(RoutingIds routingIds);
		IntermediaryInformation.IntermediaryInformationBuilder setRoutingExplicitDetails(RoutingExplicitDetails routingExplicitDetails);
		IntermediaryInformation.IntermediaryInformationBuilder setRoutingIdsAndExplicitDetails(RoutingIdsAndExplicitDetails routingIdsAndExplicitDetails);
		IntermediaryInformation.IntermediaryInformationBuilder setIntermediarySequenceNumber(Integer intermediarySequenceNumber);
		IntermediaryInformation.IntermediaryInformationBuilder setIntermediaryPartyReference(PartyReference intermediaryPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.RoutingIdsBuilder.class, getRoutingIds());
			processRosetta(path.newSubPath("routingExplicitDetails"), processor, RoutingExplicitDetails.RoutingExplicitDetailsBuilder.class, getRoutingExplicitDetails());
			processRosetta(path.newSubPath("routingIdsAndExplicitDetails"), processor, RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder.class, getRoutingIdsAndExplicitDetails());
			processor.processBasic(path.newSubPath("intermediarySequenceNumber"), Integer.class, getIntermediarySequenceNumber(), this);
			processRosetta(path.newSubPath("intermediaryPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getIntermediaryPartyReference());
		}
		

		IntermediaryInformation.IntermediaryInformationBuilder prune();
	}

	/*********************** Immutable Implementation of IntermediaryInformation  ***********************/
	class IntermediaryInformationImpl implements IntermediaryInformation {
		private final RoutingIds routingIds;
		private final RoutingExplicitDetails routingExplicitDetails;
		private final RoutingIdsAndExplicitDetails routingIdsAndExplicitDetails;
		private final Integer intermediarySequenceNumber;
		private final PartyReference intermediaryPartyReference;
		
		protected IntermediaryInformationImpl(IntermediaryInformation.IntermediaryInformationBuilder builder) {
			this.routingIds = ofNullable(builder.getRoutingIds()).map(f->f.build()).orElse(null);
			this.routingExplicitDetails = ofNullable(builder.getRoutingExplicitDetails()).map(f->f.build()).orElse(null);
			this.routingIdsAndExplicitDetails = ofNullable(builder.getRoutingIdsAndExplicitDetails()).map(f->f.build()).orElse(null);
			this.intermediarySequenceNumber = builder.getIntermediarySequenceNumber();
			this.intermediaryPartyReference = ofNullable(builder.getIntermediaryPartyReference()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("intermediarySequenceNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intermediarySequenceNumber")
		public Integer getIntermediarySequenceNumber() {
			return intermediarySequenceNumber;
		}
		
		@Override
		@RosettaAttribute("intermediaryPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intermediaryPartyReference")
		public PartyReference getIntermediaryPartyReference() {
			return intermediaryPartyReference;
		}
		
		@Override
		public IntermediaryInformation build() {
			return this;
		}
		
		@Override
		public IntermediaryInformation.IntermediaryInformationBuilder toBuilder() {
			IntermediaryInformation.IntermediaryInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IntermediaryInformation.IntermediaryInformationBuilder builder) {
			ofNullable(getRoutingIds()).ifPresent(builder::setRoutingIds);
			ofNullable(getRoutingExplicitDetails()).ifPresent(builder::setRoutingExplicitDetails);
			ofNullable(getRoutingIdsAndExplicitDetails()).ifPresent(builder::setRoutingIdsAndExplicitDetails);
			ofNullable(getIntermediarySequenceNumber()).ifPresent(builder::setIntermediarySequenceNumber);
			ofNullable(getIntermediaryPartyReference()).ifPresent(builder::setIntermediaryPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IntermediaryInformation _that = getType().cast(o);
		
			if (!Objects.equals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingExplicitDetails, _that.getRoutingExplicitDetails())) return false;
			if (!Objects.equals(routingIdsAndExplicitDetails, _that.getRoutingIdsAndExplicitDetails())) return false;
			if (!Objects.equals(intermediarySequenceNumber, _that.getIntermediarySequenceNumber())) return false;
			if (!Objects.equals(intermediaryPartyReference, _that.getIntermediaryPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingExplicitDetails != null ? routingExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (routingIdsAndExplicitDetails != null ? routingIdsAndExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (intermediarySequenceNumber != null ? intermediarySequenceNumber.hashCode() : 0);
			_result = 31 * _result + (intermediaryPartyReference != null ? intermediaryPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IntermediaryInformation {" +
				"routingIds=" + this.routingIds + ", " +
				"routingExplicitDetails=" + this.routingExplicitDetails + ", " +
				"routingIdsAndExplicitDetails=" + this.routingIdsAndExplicitDetails + ", " +
				"intermediarySequenceNumber=" + this.intermediarySequenceNumber + ", " +
				"intermediaryPartyReference=" + this.intermediaryPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of IntermediaryInformation  ***********************/
	class IntermediaryInformationBuilderImpl implements IntermediaryInformation.IntermediaryInformationBuilder {
	
		protected RoutingIds.RoutingIdsBuilder routingIds;
		protected RoutingExplicitDetails.RoutingExplicitDetailsBuilder routingExplicitDetails;
		protected RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder routingIdsAndExplicitDetails;
		protected Integer intermediarySequenceNumber;
		protected PartyReference.PartyReferenceBuilder intermediaryPartyReference;
		
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
		@RosettaAttribute("intermediarySequenceNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intermediarySequenceNumber")
		public Integer getIntermediarySequenceNumber() {
			return intermediarySequenceNumber;
		}
		
		@Override
		@RosettaAttribute("intermediaryPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intermediaryPartyReference")
		public PartyReference.PartyReferenceBuilder getIntermediaryPartyReference() {
			return intermediaryPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateIntermediaryPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (intermediaryPartyReference!=null) {
				result = intermediaryPartyReference;
			}
			else {
				result = intermediaryPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("routingIds")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingIds")
		@Override
		public IntermediaryInformation.IntermediaryInformationBuilder setRoutingIds(RoutingIds _routingIds) {
			this.routingIds = _routingIds == null ? null : _routingIds.toBuilder();
			return this;
		}
		
		@RosettaAttribute("routingExplicitDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingExplicitDetails")
		@Override
		public IntermediaryInformation.IntermediaryInformationBuilder setRoutingExplicitDetails(RoutingExplicitDetails _routingExplicitDetails) {
			this.routingExplicitDetails = _routingExplicitDetails == null ? null : _routingExplicitDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("routingIdsAndExplicitDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingIdsAndExplicitDetails")
		@Override
		public IntermediaryInformation.IntermediaryInformationBuilder setRoutingIdsAndExplicitDetails(RoutingIdsAndExplicitDetails _routingIdsAndExplicitDetails) {
			this.routingIdsAndExplicitDetails = _routingIdsAndExplicitDetails == null ? null : _routingIdsAndExplicitDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("intermediarySequenceNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intermediarySequenceNumber")
		@Override
		public IntermediaryInformation.IntermediaryInformationBuilder setIntermediarySequenceNumber(Integer _intermediarySequenceNumber) {
			this.intermediarySequenceNumber = _intermediarySequenceNumber == null ? null : _intermediarySequenceNumber;
			return this;
		}
		
		@RosettaAttribute("intermediaryPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intermediaryPartyReference")
		@Override
		public IntermediaryInformation.IntermediaryInformationBuilder setIntermediaryPartyReference(PartyReference _intermediaryPartyReference) {
			this.intermediaryPartyReference = _intermediaryPartyReference == null ? null : _intermediaryPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public IntermediaryInformation build() {
			return new IntermediaryInformation.IntermediaryInformationImpl(this);
		}
		
		@Override
		public IntermediaryInformation.IntermediaryInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IntermediaryInformation.IntermediaryInformationBuilder prune() {
			if (routingIds!=null && !routingIds.prune().hasData()) routingIds = null;
			if (routingExplicitDetails!=null && !routingExplicitDetails.prune().hasData()) routingExplicitDetails = null;
			if (routingIdsAndExplicitDetails!=null && !routingIdsAndExplicitDetails.prune().hasData()) routingIdsAndExplicitDetails = null;
			if (intermediaryPartyReference!=null && !intermediaryPartyReference.prune().hasData()) intermediaryPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingIds()!=null && getRoutingIds().hasData()) return true;
			if (getRoutingExplicitDetails()!=null && getRoutingExplicitDetails().hasData()) return true;
			if (getRoutingIdsAndExplicitDetails()!=null && getRoutingIdsAndExplicitDetails().hasData()) return true;
			if (getIntermediarySequenceNumber()!=null) return true;
			if (getIntermediaryPartyReference()!=null && getIntermediaryPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IntermediaryInformation.IntermediaryInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IntermediaryInformation.IntermediaryInformationBuilder o = (IntermediaryInformation.IntermediaryInformationBuilder) other;
			
			merger.mergeRosetta(getRoutingIds(), o.getRoutingIds(), this::setRoutingIds);
			merger.mergeRosetta(getRoutingExplicitDetails(), o.getRoutingExplicitDetails(), this::setRoutingExplicitDetails);
			merger.mergeRosetta(getRoutingIdsAndExplicitDetails(), o.getRoutingIdsAndExplicitDetails(), this::setRoutingIdsAndExplicitDetails);
			merger.mergeRosetta(getIntermediaryPartyReference(), o.getIntermediaryPartyReference(), this::setIntermediaryPartyReference);
			
			merger.mergeBasic(getIntermediarySequenceNumber(), o.getIntermediarySequenceNumber(), this::setIntermediarySequenceNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IntermediaryInformation _that = getType().cast(o);
		
			if (!Objects.equals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingExplicitDetails, _that.getRoutingExplicitDetails())) return false;
			if (!Objects.equals(routingIdsAndExplicitDetails, _that.getRoutingIdsAndExplicitDetails())) return false;
			if (!Objects.equals(intermediarySequenceNumber, _that.getIntermediarySequenceNumber())) return false;
			if (!Objects.equals(intermediaryPartyReference, _that.getIntermediaryPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingExplicitDetails != null ? routingExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (routingIdsAndExplicitDetails != null ? routingIdsAndExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (intermediarySequenceNumber != null ? intermediarySequenceNumber.hashCode() : 0);
			_result = 31 * _result + (intermediaryPartyReference != null ? intermediaryPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IntermediaryInformationBuilder {" +
				"routingIds=" + this.routingIds + ", " +
				"routingExplicitDetails=" + this.routingExplicitDetails + ", " +
				"routingIdsAndExplicitDetails=" + this.routingIdsAndExplicitDetails + ", " +
				"intermediarySequenceNumber=" + this.intermediarySequenceNumber + ", " +
				"intermediaryPartyReference=" + this.intermediaryPartyReference +
			'}';
		}
	}
}
