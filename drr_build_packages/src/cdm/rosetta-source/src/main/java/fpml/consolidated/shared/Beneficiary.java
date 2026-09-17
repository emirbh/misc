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
import fpml.consolidated.shared.meta.BeneficiaryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the beneficiary of the funds.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the beneficiary of the funds.
 *
 */
@RosettaDataType(value="Beneficiary", builder=Beneficiary.BeneficiaryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Beneficiary", model="fpml", builder=Beneficiary.BeneficiaryBuilderImpl.class, version="2.1.1")
public interface Beneficiary extends RosettaModelObject {

	BeneficiaryMeta metaData = new BeneficiaryMeta();

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
	 * Provision Link to the party acting as beneficiary. This element can only appear within the beneficiary container element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Link to the party acting as beneficiary. This element can only appear within the beneficiary container element.
	 *
	 */
	PartyReference getBeneficiaryPartyReference();

	/*********************** Build Methods  ***********************/
	Beneficiary build();
	
	Beneficiary.BeneficiaryBuilder toBuilder();
	
	static Beneficiary.BeneficiaryBuilder builder() {
		return new Beneficiary.BeneficiaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Beneficiary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Beneficiary> getType() {
		return Beneficiary.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.class, getRoutingIds());
		processRosetta(path.newSubPath("routingExplicitDetails"), processor, RoutingExplicitDetails.class, getRoutingExplicitDetails());
		processRosetta(path.newSubPath("routingIdsAndExplicitDetails"), processor, RoutingIdsAndExplicitDetails.class, getRoutingIdsAndExplicitDetails());
		processRosetta(path.newSubPath("beneficiaryPartyReference"), processor, PartyReference.class, getBeneficiaryPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BeneficiaryBuilder extends Beneficiary, RosettaModelObjectBuilder {
		RoutingIds.RoutingIdsBuilder getOrCreateRoutingIds();
		@Override
		RoutingIds.RoutingIdsBuilder getRoutingIds();
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder getOrCreateRoutingExplicitDetails();
		@Override
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder getRoutingExplicitDetails();
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getOrCreateRoutingIdsAndExplicitDetails();
		@Override
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getRoutingIdsAndExplicitDetails();
		PartyReference.PartyReferenceBuilder getOrCreateBeneficiaryPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBeneficiaryPartyReference();
		Beneficiary.BeneficiaryBuilder setRoutingIds(RoutingIds routingIds);
		Beneficiary.BeneficiaryBuilder setRoutingExplicitDetails(RoutingExplicitDetails routingExplicitDetails);
		Beneficiary.BeneficiaryBuilder setRoutingIdsAndExplicitDetails(RoutingIdsAndExplicitDetails routingIdsAndExplicitDetails);
		Beneficiary.BeneficiaryBuilder setBeneficiaryPartyReference(PartyReference beneficiaryPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.RoutingIdsBuilder.class, getRoutingIds());
			processRosetta(path.newSubPath("routingExplicitDetails"), processor, RoutingExplicitDetails.RoutingExplicitDetailsBuilder.class, getRoutingExplicitDetails());
			processRosetta(path.newSubPath("routingIdsAndExplicitDetails"), processor, RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder.class, getRoutingIdsAndExplicitDetails());
			processRosetta(path.newSubPath("beneficiaryPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBeneficiaryPartyReference());
		}
		

		Beneficiary.BeneficiaryBuilder prune();
	}

	/*********************** Immutable Implementation of Beneficiary  ***********************/
	class BeneficiaryImpl implements Beneficiary {
		private final RoutingIds routingIds;
		private final RoutingExplicitDetails routingExplicitDetails;
		private final RoutingIdsAndExplicitDetails routingIdsAndExplicitDetails;
		private final PartyReference beneficiaryPartyReference;
		
		protected BeneficiaryImpl(Beneficiary.BeneficiaryBuilder builder) {
			this.routingIds = ofNullable(builder.getRoutingIds()).map(f->f.build()).orElse(null);
			this.routingExplicitDetails = ofNullable(builder.getRoutingExplicitDetails()).map(f->f.build()).orElse(null);
			this.routingIdsAndExplicitDetails = ofNullable(builder.getRoutingIdsAndExplicitDetails()).map(f->f.build()).orElse(null);
			this.beneficiaryPartyReference = ofNullable(builder.getBeneficiaryPartyReference()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("beneficiaryPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiaryPartyReference")
		public PartyReference getBeneficiaryPartyReference() {
			return beneficiaryPartyReference;
		}
		
		@Override
		public Beneficiary build() {
			return this;
		}
		
		@Override
		public Beneficiary.BeneficiaryBuilder toBuilder() {
			Beneficiary.BeneficiaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Beneficiary.BeneficiaryBuilder builder) {
			ofNullable(getRoutingIds()).ifPresent(builder::setRoutingIds);
			ofNullable(getRoutingExplicitDetails()).ifPresent(builder::setRoutingExplicitDetails);
			ofNullable(getRoutingIdsAndExplicitDetails()).ifPresent(builder::setRoutingIdsAndExplicitDetails);
			ofNullable(getBeneficiaryPartyReference()).ifPresent(builder::setBeneficiaryPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Beneficiary _that = getType().cast(o);
		
			if (!Objects.equals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingExplicitDetails, _that.getRoutingExplicitDetails())) return false;
			if (!Objects.equals(routingIdsAndExplicitDetails, _that.getRoutingIdsAndExplicitDetails())) return false;
			if (!Objects.equals(beneficiaryPartyReference, _that.getBeneficiaryPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingExplicitDetails != null ? routingExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (routingIdsAndExplicitDetails != null ? routingIdsAndExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (beneficiaryPartyReference != null ? beneficiaryPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Beneficiary {" +
				"routingIds=" + this.routingIds + ", " +
				"routingExplicitDetails=" + this.routingExplicitDetails + ", " +
				"routingIdsAndExplicitDetails=" + this.routingIdsAndExplicitDetails + ", " +
				"beneficiaryPartyReference=" + this.beneficiaryPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of Beneficiary  ***********************/
	class BeneficiaryBuilderImpl implements Beneficiary.BeneficiaryBuilder {
	
		protected RoutingIds.RoutingIdsBuilder routingIds;
		protected RoutingExplicitDetails.RoutingExplicitDetailsBuilder routingExplicitDetails;
		protected RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder routingIdsAndExplicitDetails;
		protected PartyReference.PartyReferenceBuilder beneficiaryPartyReference;
		
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
		@RosettaAttribute("beneficiaryPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiaryPartyReference")
		public PartyReference.PartyReferenceBuilder getBeneficiaryPartyReference() {
			return beneficiaryPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBeneficiaryPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (beneficiaryPartyReference!=null) {
				result = beneficiaryPartyReference;
			}
			else {
				result = beneficiaryPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("routingIds")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingIds")
		@Override
		public Beneficiary.BeneficiaryBuilder setRoutingIds(RoutingIds _routingIds) {
			this.routingIds = _routingIds == null ? null : _routingIds.toBuilder();
			return this;
		}
		
		@RosettaAttribute("routingExplicitDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingExplicitDetails")
		@Override
		public Beneficiary.BeneficiaryBuilder setRoutingExplicitDetails(RoutingExplicitDetails _routingExplicitDetails) {
			this.routingExplicitDetails = _routingExplicitDetails == null ? null : _routingExplicitDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("routingIdsAndExplicitDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingIdsAndExplicitDetails")
		@Override
		public Beneficiary.BeneficiaryBuilder setRoutingIdsAndExplicitDetails(RoutingIdsAndExplicitDetails _routingIdsAndExplicitDetails) {
			this.routingIdsAndExplicitDetails = _routingIdsAndExplicitDetails == null ? null : _routingIdsAndExplicitDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("beneficiaryPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiaryPartyReference")
		@Override
		public Beneficiary.BeneficiaryBuilder setBeneficiaryPartyReference(PartyReference _beneficiaryPartyReference) {
			this.beneficiaryPartyReference = _beneficiaryPartyReference == null ? null : _beneficiaryPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public Beneficiary build() {
			return new Beneficiary.BeneficiaryImpl(this);
		}
		
		@Override
		public Beneficiary.BeneficiaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Beneficiary.BeneficiaryBuilder prune() {
			if (routingIds!=null && !routingIds.prune().hasData()) routingIds = null;
			if (routingExplicitDetails!=null && !routingExplicitDetails.prune().hasData()) routingExplicitDetails = null;
			if (routingIdsAndExplicitDetails!=null && !routingIdsAndExplicitDetails.prune().hasData()) routingIdsAndExplicitDetails = null;
			if (beneficiaryPartyReference!=null && !beneficiaryPartyReference.prune().hasData()) beneficiaryPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingIds()!=null && getRoutingIds().hasData()) return true;
			if (getRoutingExplicitDetails()!=null && getRoutingExplicitDetails().hasData()) return true;
			if (getRoutingIdsAndExplicitDetails()!=null && getRoutingIdsAndExplicitDetails().hasData()) return true;
			if (getBeneficiaryPartyReference()!=null && getBeneficiaryPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Beneficiary.BeneficiaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Beneficiary.BeneficiaryBuilder o = (Beneficiary.BeneficiaryBuilder) other;
			
			merger.mergeRosetta(getRoutingIds(), o.getRoutingIds(), this::setRoutingIds);
			merger.mergeRosetta(getRoutingExplicitDetails(), o.getRoutingExplicitDetails(), this::setRoutingExplicitDetails);
			merger.mergeRosetta(getRoutingIdsAndExplicitDetails(), o.getRoutingIdsAndExplicitDetails(), this::setRoutingIdsAndExplicitDetails);
			merger.mergeRosetta(getBeneficiaryPartyReference(), o.getBeneficiaryPartyReference(), this::setBeneficiaryPartyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Beneficiary _that = getType().cast(o);
		
			if (!Objects.equals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingExplicitDetails, _that.getRoutingExplicitDetails())) return false;
			if (!Objects.equals(routingIdsAndExplicitDetails, _that.getRoutingIdsAndExplicitDetails())) return false;
			if (!Objects.equals(beneficiaryPartyReference, _that.getBeneficiaryPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingExplicitDetails != null ? routingExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (routingIdsAndExplicitDetails != null ? routingIdsAndExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (beneficiaryPartyReference != null ? beneficiaryPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BeneficiaryBuilder {" +
				"routingIds=" + this.routingIds + ", " +
				"routingExplicitDetails=" + this.routingExplicitDetails + ", " +
				"routingIdsAndExplicitDetails=" + this.routingIdsAndExplicitDetails + ", " +
				"beneficiaryPartyReference=" + this.beneficiaryPartyReference +
			'}';
		}
	}
}
