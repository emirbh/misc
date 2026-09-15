package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.loan.meta.ProRataFacilitiesMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that defines a restriction pertaining to which facilities must be traded on a pro-rata basis.
 *
 */
@RosettaDataType(value="ProRataFacilities", builder=ProRataFacilities.ProRataFacilitiesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ProRataFacilities", model="fpml", builder=ProRataFacilities.ProRataFacilitiesBuilderImpl.class, version="2.1.1")
public interface ProRataFacilities extends RosettaModelObject {

	ProRataFacilitiesMeta metaData = new ProRataFacilitiesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends FacilityReference> getFacilityReference();

	/*********************** Build Methods  ***********************/
	ProRataFacilities build();
	
	ProRataFacilities.ProRataFacilitiesBuilder toBuilder();
	
	static ProRataFacilities.ProRataFacilitiesBuilder builder() {
		return new ProRataFacilities.ProRataFacilitiesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ProRataFacilities> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ProRataFacilities> getType() {
		return ProRataFacilities.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ProRataFacilitiesBuilder extends ProRataFacilities, RosettaModelObjectBuilder {
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference(int index);
		@Override
		List<? extends FacilityReference.FacilityReferenceBuilder> getFacilityReference();
		ProRataFacilities.ProRataFacilitiesBuilder addFacilityReference(FacilityReference facilityReference);
		ProRataFacilities.ProRataFacilitiesBuilder addFacilityReference(FacilityReference facilityReference, int idx);
		ProRataFacilities.ProRataFacilitiesBuilder addFacilityReference(List<? extends FacilityReference> facilityReference);
		ProRataFacilities.ProRataFacilitiesBuilder setFacilityReference(List<? extends FacilityReference> facilityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
		}
		

		ProRataFacilities.ProRataFacilitiesBuilder prune();
	}

	/*********************** Immutable Implementation of ProRataFacilities  ***********************/
	class ProRataFacilitiesImpl implements ProRataFacilities {
		private final List<? extends FacilityReference> facilityReference;
		
		protected ProRataFacilitiesImpl(ProRataFacilities.ProRataFacilitiesBuilder builder) {
			this.facilityReference = ofNullable(builder.getFacilityReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("facilityReference")
		public List<? extends FacilityReference> getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public ProRataFacilities build() {
			return this;
		}
		
		@Override
		public ProRataFacilities.ProRataFacilitiesBuilder toBuilder() {
			ProRataFacilities.ProRataFacilitiesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProRataFacilities.ProRataFacilitiesBuilder builder) {
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProRataFacilities _that = getType().cast(o);
		
			if (!ListEquals.listEquals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProRataFacilities {" +
				"facilityReference=" + this.facilityReference +
			'}';
		}
	}

	/*********************** Builder Implementation of ProRataFacilities  ***********************/
	class ProRataFacilitiesBuilderImpl implements ProRataFacilities.ProRataFacilitiesBuilder {
	
		protected List<FacilityReference.FacilityReferenceBuilder> facilityReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("facilityReference")
		public List<? extends FacilityReference.FacilityReferenceBuilder> getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference(int index) {
			if (facilityReference==null) {
				this.facilityReference = new ArrayList<>();
			}
			return getIndex(facilityReference, index, () -> {
						FacilityReference.FacilityReferenceBuilder newFacilityReference = FacilityReference.builder();
						return newFacilityReference;
					});
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public ProRataFacilities.ProRataFacilitiesBuilder addFacilityReference(FacilityReference _facilityReference) {
			if (_facilityReference != null) {
				this.facilityReference.add(_facilityReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public ProRataFacilities.ProRataFacilitiesBuilder addFacilityReference(FacilityReference _facilityReference, int idx) {
			getIndex(this.facilityReference, idx, () -> _facilityReference.toBuilder());
			return this;
		}
		
		@Override
		public ProRataFacilities.ProRataFacilitiesBuilder addFacilityReference(List<? extends FacilityReference> facilityReferences) {
			if (facilityReferences != null) {
				for (final FacilityReference toAdd : facilityReferences) {
					this.facilityReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("facilityReference")
		@Override
		public ProRataFacilities.ProRataFacilitiesBuilder setFacilityReference(List<? extends FacilityReference> facilityReferences) {
			if (facilityReferences == null) {
				this.facilityReference = new ArrayList<>();
			} else {
				this.facilityReference = facilityReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ProRataFacilities build() {
			return new ProRataFacilities.ProRataFacilitiesImpl(this);
		}
		
		@Override
		public ProRataFacilities.ProRataFacilitiesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProRataFacilities.ProRataFacilitiesBuilder prune() {
			facilityReference = facilityReference.stream().filter(b->b!=null).<FacilityReference.FacilityReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFacilityReference()!=null && getFacilityReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProRataFacilities.ProRataFacilitiesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProRataFacilities.ProRataFacilitiesBuilder o = (ProRataFacilities.ProRataFacilitiesBuilder) other;
			
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::getOrCreateFacilityReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProRataFacilities _that = getType().cast(o);
		
			if (!ListEquals.listEquals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProRataFacilitiesBuilder {" +
				"facilityReference=" + this.facilityReference +
			'}';
		}
	}
}
