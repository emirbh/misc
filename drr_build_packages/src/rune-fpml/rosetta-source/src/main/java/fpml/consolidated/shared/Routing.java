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
import fpml.consolidated.shared.meta.RoutingMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that provides three alternative ways of identifying a party involved in the routing of a payment. The identification may use payment system identifiers only; actual name, address and other reference information; or a combination of both.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that provides three alternative ways of identifying a party involved in the routing of a payment. The identification may use payment system identifiers only; actual name, address and other reference information; or a combination of both.
 *
 */
@RosettaDataType(value="Routing", builder=Routing.RoutingBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Routing", model="fpml", builder=Routing.RoutingBuilderImpl.class, version="2.1.1")
public interface Routing extends RosettaModelObject {

	RoutingMeta metaData = new RoutingMeta();

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

	/*********************** Build Methods  ***********************/
	Routing build();
	
	Routing.RoutingBuilder toBuilder();
	
	static Routing.RoutingBuilder builder() {
		return new Routing.RoutingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Routing> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Routing> getType() {
		return Routing.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.class, getRoutingIds());
		processRosetta(path.newSubPath("routingExplicitDetails"), processor, RoutingExplicitDetails.class, getRoutingExplicitDetails());
		processRosetta(path.newSubPath("routingIdsAndExplicitDetails"), processor, RoutingIdsAndExplicitDetails.class, getRoutingIdsAndExplicitDetails());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RoutingBuilder extends Routing, RosettaModelObjectBuilder {
		RoutingIds.RoutingIdsBuilder getOrCreateRoutingIds();
		@Override
		RoutingIds.RoutingIdsBuilder getRoutingIds();
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder getOrCreateRoutingExplicitDetails();
		@Override
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder getRoutingExplicitDetails();
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getOrCreateRoutingIdsAndExplicitDetails();
		@Override
		RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder getRoutingIdsAndExplicitDetails();
		Routing.RoutingBuilder setRoutingIds(RoutingIds routingIds);
		Routing.RoutingBuilder setRoutingExplicitDetails(RoutingExplicitDetails routingExplicitDetails);
		Routing.RoutingBuilder setRoutingIdsAndExplicitDetails(RoutingIdsAndExplicitDetails routingIdsAndExplicitDetails);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("routingIds"), processor, RoutingIds.RoutingIdsBuilder.class, getRoutingIds());
			processRosetta(path.newSubPath("routingExplicitDetails"), processor, RoutingExplicitDetails.RoutingExplicitDetailsBuilder.class, getRoutingExplicitDetails());
			processRosetta(path.newSubPath("routingIdsAndExplicitDetails"), processor, RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder.class, getRoutingIdsAndExplicitDetails());
		}
		

		Routing.RoutingBuilder prune();
	}

	/*********************** Immutable Implementation of Routing  ***********************/
	class RoutingImpl implements Routing {
		private final RoutingIds routingIds;
		private final RoutingExplicitDetails routingExplicitDetails;
		private final RoutingIdsAndExplicitDetails routingIdsAndExplicitDetails;
		
		protected RoutingImpl(Routing.RoutingBuilder builder) {
			this.routingIds = ofNullable(builder.getRoutingIds()).map(f->f.build()).orElse(null);
			this.routingExplicitDetails = ofNullable(builder.getRoutingExplicitDetails()).map(f->f.build()).orElse(null);
			this.routingIdsAndExplicitDetails = ofNullable(builder.getRoutingIdsAndExplicitDetails()).map(f->f.build()).orElse(null);
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
		public Routing build() {
			return this;
		}
		
		@Override
		public Routing.RoutingBuilder toBuilder() {
			Routing.RoutingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Routing.RoutingBuilder builder) {
			ofNullable(getRoutingIds()).ifPresent(builder::setRoutingIds);
			ofNullable(getRoutingExplicitDetails()).ifPresent(builder::setRoutingExplicitDetails);
			ofNullable(getRoutingIdsAndExplicitDetails()).ifPresent(builder::setRoutingIdsAndExplicitDetails);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Routing _that = getType().cast(o);
		
			if (!Objects.equals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingExplicitDetails, _that.getRoutingExplicitDetails())) return false;
			if (!Objects.equals(routingIdsAndExplicitDetails, _that.getRoutingIdsAndExplicitDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingExplicitDetails != null ? routingExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (routingIdsAndExplicitDetails != null ? routingIdsAndExplicitDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Routing {" +
				"routingIds=" + this.routingIds + ", " +
				"routingExplicitDetails=" + this.routingExplicitDetails + ", " +
				"routingIdsAndExplicitDetails=" + this.routingIdsAndExplicitDetails +
			'}';
		}
	}

	/*********************** Builder Implementation of Routing  ***********************/
	class RoutingBuilderImpl implements Routing.RoutingBuilder {
	
		protected RoutingIds.RoutingIdsBuilder routingIds;
		protected RoutingExplicitDetails.RoutingExplicitDetailsBuilder routingExplicitDetails;
		protected RoutingIdsAndExplicitDetails.RoutingIdsAndExplicitDetailsBuilder routingIdsAndExplicitDetails;
		
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
		
		@RosettaAttribute("routingIds")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingIds")
		@Override
		public Routing.RoutingBuilder setRoutingIds(RoutingIds _routingIds) {
			this.routingIds = _routingIds == null ? null : _routingIds.toBuilder();
			return this;
		}
		
		@RosettaAttribute("routingExplicitDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingExplicitDetails")
		@Override
		public Routing.RoutingBuilder setRoutingExplicitDetails(RoutingExplicitDetails _routingExplicitDetails) {
			this.routingExplicitDetails = _routingExplicitDetails == null ? null : _routingExplicitDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("routingIdsAndExplicitDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("routingIdsAndExplicitDetails")
		@Override
		public Routing.RoutingBuilder setRoutingIdsAndExplicitDetails(RoutingIdsAndExplicitDetails _routingIdsAndExplicitDetails) {
			this.routingIdsAndExplicitDetails = _routingIdsAndExplicitDetails == null ? null : _routingIdsAndExplicitDetails.toBuilder();
			return this;
		}
		
		@Override
		public Routing build() {
			return new Routing.RoutingImpl(this);
		}
		
		@Override
		public Routing.RoutingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Routing.RoutingBuilder prune() {
			if (routingIds!=null && !routingIds.prune().hasData()) routingIds = null;
			if (routingExplicitDetails!=null && !routingExplicitDetails.prune().hasData()) routingExplicitDetails = null;
			if (routingIdsAndExplicitDetails!=null && !routingIdsAndExplicitDetails.prune().hasData()) routingIdsAndExplicitDetails = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingIds()!=null && getRoutingIds().hasData()) return true;
			if (getRoutingExplicitDetails()!=null && getRoutingExplicitDetails().hasData()) return true;
			if (getRoutingIdsAndExplicitDetails()!=null && getRoutingIdsAndExplicitDetails().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Routing.RoutingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Routing.RoutingBuilder o = (Routing.RoutingBuilder) other;
			
			merger.mergeRosetta(getRoutingIds(), o.getRoutingIds(), this::setRoutingIds);
			merger.mergeRosetta(getRoutingExplicitDetails(), o.getRoutingExplicitDetails(), this::setRoutingExplicitDetails);
			merger.mergeRosetta(getRoutingIdsAndExplicitDetails(), o.getRoutingIdsAndExplicitDetails(), this::setRoutingIdsAndExplicitDetails);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Routing _that = getType().cast(o);
		
			if (!Objects.equals(routingIds, _that.getRoutingIds())) return false;
			if (!Objects.equals(routingExplicitDetails, _that.getRoutingExplicitDetails())) return false;
			if (!Objects.equals(routingIdsAndExplicitDetails, _that.getRoutingIdsAndExplicitDetails())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIds != null ? routingIds.hashCode() : 0);
			_result = 31 * _result + (routingExplicitDetails != null ? routingExplicitDetails.hashCode() : 0);
			_result = 31 * _result + (routingIdsAndExplicitDetails != null ? routingIdsAndExplicitDetails.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingBuilder {" +
				"routingIds=" + this.routingIds + ", " +
				"routingExplicitDetails=" + this.routingExplicitDetails + ", " +
				"routingIdsAndExplicitDetails=" + this.routingIdsAndExplicitDetails +
			'}';
		}
	}
}
