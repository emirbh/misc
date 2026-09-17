package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.AdditionalRepresentationMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the Additional Representation.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(o)" * name "Additional Representations(s)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="AdditionalRepresentation", builder=AdditionalRepresentation.AdditionalRepresentationBuilderImpl.class, version="6.23.0")
@RuneDataType(value="AdditionalRepresentation", model="cdm", builder=AdditionalRepresentation.AdditionalRepresentationBuilderImpl.class, version="6.23.0")
public interface AdditionalRepresentation extends RosettaModelObject {

	AdditionalRepresentationMeta metaData = new AdditionalRepresentationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A qualification as to whether the Additional Representation is applicable.
	 */
	List<? extends AdditionalRepresentationElection> getPartyElection();
	/**
	 * A supplemental custom election that might be specified by the parties for the purpose of specifying the Additional Representation.
	 */
	String getCustomElection();

	/*********************** Build Methods  ***********************/
	AdditionalRepresentation build();
	
	AdditionalRepresentation.AdditionalRepresentationBuilder toBuilder();
	
	static AdditionalRepresentation.AdditionalRepresentationBuilder builder() {
		return new AdditionalRepresentation.AdditionalRepresentationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdditionalRepresentation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdditionalRepresentation> getType() {
		return AdditionalRepresentation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElection"), processor, AdditionalRepresentationElection.class, getPartyElection());
		processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdditionalRepresentationBuilder extends AdditionalRepresentation, RosettaModelObjectBuilder {
		AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder> getPartyElection();
		AdditionalRepresentation.AdditionalRepresentationBuilder addPartyElection(AdditionalRepresentationElection partyElection);
		AdditionalRepresentation.AdditionalRepresentationBuilder addPartyElection(AdditionalRepresentationElection partyElection, int idx);
		AdditionalRepresentation.AdditionalRepresentationBuilder addPartyElection(List<? extends AdditionalRepresentationElection> partyElection);
		AdditionalRepresentation.AdditionalRepresentationBuilder setPartyElection(List<? extends AdditionalRepresentationElection> partyElection);
		AdditionalRepresentation.AdditionalRepresentationBuilder setCustomElection(String customElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElection"), processor, AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder.class, getPartyElection());
			processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
		}
		

		AdditionalRepresentation.AdditionalRepresentationBuilder prune();
	}

	/*********************** Immutable Implementation of AdditionalRepresentation  ***********************/
	class AdditionalRepresentationImpl implements AdditionalRepresentation {
		private final List<? extends AdditionalRepresentationElection> partyElection;
		private final String customElection;
		
		protected AdditionalRepresentationImpl(AdditionalRepresentation.AdditionalRepresentationBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.customElection = builder.getCustomElection();
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends AdditionalRepresentationElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		@RosettaAttribute("customElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customElection")
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public AdditionalRepresentation build() {
			return this;
		}
		
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder toBuilder() {
			AdditionalRepresentation.AdditionalRepresentationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalRepresentation.AdditionalRepresentationBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
			ofNullable(getCustomElection()).ifPresent(builder::setCustomElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalRepresentation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalRepresentation {" +
				"partyElection=" + this.partyElection + ", " +
				"customElection=" + this.customElection +
			'}';
		}
	}

	/*********************** Builder Implementation of AdditionalRepresentation  ***********************/
	class AdditionalRepresentationBuilderImpl implements AdditionalRepresentation.AdditionalRepresentationBuilder {
	
		protected List<AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder> partyElection = new ArrayList<>();
		protected String customElection;
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder newPartyElection = AdditionalRepresentationElection.builder();
						return newPartyElection;
					});
		}
		
		@Override
		@RosettaAttribute("customElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customElection")
		public String getCustomElection() {
			return customElection;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder addPartyElection(AdditionalRepresentationElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder addPartyElection(AdditionalRepresentationElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder addPartyElection(List<? extends AdditionalRepresentationElection> partyElections) {
			if (partyElections != null) {
				for (final AdditionalRepresentationElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder setPartyElection(List<? extends AdditionalRepresentationElection> partyElections) {
			if (partyElections == null) {
				this.partyElection = new ArrayList<>();
			} else {
				this.partyElection = partyElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("customElection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customElection")
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder setCustomElection(String _customElection) {
			this.customElection = _customElection == null ? null : _customElection;
			return this;
		}
		
		@Override
		public AdditionalRepresentation build() {
			return new AdditionalRepresentation.AdditionalRepresentationImpl(this);
		}
		
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<AdditionalRepresentationElection.AdditionalRepresentationElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCustomElection()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalRepresentation.AdditionalRepresentationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalRepresentation.AdditionalRepresentationBuilder o = (AdditionalRepresentation.AdditionalRepresentationBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			merger.mergeBasic(getCustomElection(), o.getCustomElection(), this::setCustomElection);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalRepresentation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalRepresentationBuilder {" +
				"partyElection=" + this.partyElection + ", " +
				"customElection=" + this.customElection +
			'}';
		}
	}
}
