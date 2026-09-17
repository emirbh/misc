package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.ExposureScopeMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
 * Optionally, for each party, specifies the amendments to the included coverage in the calculation of Exposure.
 * @version 6.23.0
 */
@RosettaDataType(value="ExposureScope", builder=ExposureScope.ExposureScopeBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ExposureScope", model="cdm", builder=ExposureScope.ExposureScopeBuilderImpl.class, version="6.23.0")
public interface ExposureScope extends RosettaModelObject {

	ExposureScopeMeta metaData = new ExposureScopeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the electice scope for a specific party.
	 */
	List<? extends LegacyExposureScopeElection> getPartyElection();

	/*********************** Build Methods  ***********************/
	ExposureScope build();
	
	ExposureScope.ExposureScopeBuilder toBuilder();
	
	static ExposureScope.ExposureScopeBuilder builder() {
		return new ExposureScope.ExposureScopeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExposureScope> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExposureScope> getType() {
		return ExposureScope.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElection"), processor, LegacyExposureScopeElection.class, getPartyElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExposureScopeBuilder extends ExposureScope, RosettaModelObjectBuilder {
		LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder> getPartyElection();
		ExposureScope.ExposureScopeBuilder addPartyElection(LegacyExposureScopeElection partyElection);
		ExposureScope.ExposureScopeBuilder addPartyElection(LegacyExposureScopeElection partyElection, int idx);
		ExposureScope.ExposureScopeBuilder addPartyElection(List<? extends LegacyExposureScopeElection> partyElection);
		ExposureScope.ExposureScopeBuilder setPartyElection(List<? extends LegacyExposureScopeElection> partyElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElection"), processor, LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder.class, getPartyElection());
		}
		

		ExposureScope.ExposureScopeBuilder prune();
	}

	/*********************** Immutable Implementation of ExposureScope  ***********************/
	class ExposureScopeImpl implements ExposureScope {
		private final List<? extends LegacyExposureScopeElection> partyElection;
		
		protected ExposureScopeImpl(ExposureScope.ExposureScopeBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends LegacyExposureScopeElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public ExposureScope build() {
			return this;
		}
		
		@Override
		public ExposureScope.ExposureScopeBuilder toBuilder() {
			ExposureScope.ExposureScopeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExposureScope.ExposureScopeBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExposureScope _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExposureScope {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}

	/*********************** Builder Implementation of ExposureScope  ***********************/
	class ExposureScopeBuilderImpl implements ExposureScope.ExposureScopeBuilder {
	
		protected List<LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder> partyElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder newPartyElection = LegacyExposureScopeElection.builder();
						return newPartyElection;
					});
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public ExposureScope.ExposureScopeBuilder addPartyElection(LegacyExposureScopeElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExposureScope.ExposureScopeBuilder addPartyElection(LegacyExposureScopeElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public ExposureScope.ExposureScopeBuilder addPartyElection(List<? extends LegacyExposureScopeElection> partyElections) {
			if (partyElections != null) {
				for (final LegacyExposureScopeElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public ExposureScope.ExposureScopeBuilder setPartyElection(List<? extends LegacyExposureScopeElection> partyElections) {
			if (partyElections == null) {
				this.partyElection = new ArrayList<>();
			} else {
				this.partyElection = partyElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExposureScope build() {
			return new ExposureScope.ExposureScopeImpl(this);
		}
		
		@Override
		public ExposureScope.ExposureScopeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExposureScope.ExposureScopeBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<LegacyExposureScopeElection.LegacyExposureScopeElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExposureScope.ExposureScopeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExposureScope.ExposureScopeBuilder o = (ExposureScope.ExposureScopeBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExposureScope _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExposureScopeBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
