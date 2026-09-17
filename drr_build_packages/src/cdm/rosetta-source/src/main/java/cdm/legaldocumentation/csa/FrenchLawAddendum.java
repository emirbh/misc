package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.FrenchLawAddendumMeta;
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
 * A class to specify party specific elections when a Collateral Transfer Agreement is governed by French Law.
 * @version 6.23.0
 */
@RosettaDataType(value="FrenchLawAddendum", builder=FrenchLawAddendum.FrenchLawAddendumBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FrenchLawAddendum", model="cdm", builder=FrenchLawAddendum.FrenchLawAddendumBuilderImpl.class, version="6.23.0")
public interface FrenchLawAddendum extends RosettaModelObject {

	FrenchLawAddendumMeta metaData = new FrenchLawAddendumMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The qualification of whether the French Law Addendum is deemed applicable by the parties (True) or not (False).
	 */
	Boolean getIsApplicable();
	/**
	 * The parties French Law Addendum Elections.
	 */
	List<? extends FrenchLawAddendumElection> getPartyElection();

	/*********************** Build Methods  ***********************/
	FrenchLawAddendum build();
	
	FrenchLawAddendum.FrenchLawAddendumBuilder toBuilder();
	
	static FrenchLawAddendum.FrenchLawAddendumBuilder builder() {
		return new FrenchLawAddendum.FrenchLawAddendumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FrenchLawAddendum> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FrenchLawAddendum> getType() {
		return FrenchLawAddendum.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processRosetta(path.newSubPath("partyElection"), processor, FrenchLawAddendumElection.class, getPartyElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FrenchLawAddendumBuilder extends FrenchLawAddendum, RosettaModelObjectBuilder {
		FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder> getPartyElection();
		FrenchLawAddendum.FrenchLawAddendumBuilder setIsApplicable(Boolean isApplicable);
		FrenchLawAddendum.FrenchLawAddendumBuilder addPartyElection(FrenchLawAddendumElection partyElection);
		FrenchLawAddendum.FrenchLawAddendumBuilder addPartyElection(FrenchLawAddendumElection partyElection, int idx);
		FrenchLawAddendum.FrenchLawAddendumBuilder addPartyElection(List<? extends FrenchLawAddendumElection> partyElection);
		FrenchLawAddendum.FrenchLawAddendumBuilder setPartyElection(List<? extends FrenchLawAddendumElection> partyElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processRosetta(path.newSubPath("partyElection"), processor, FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder.class, getPartyElection());
		}
		

		FrenchLawAddendum.FrenchLawAddendumBuilder prune();
	}

	/*********************** Immutable Implementation of FrenchLawAddendum  ***********************/
	class FrenchLawAddendumImpl implements FrenchLawAddendum {
		private final Boolean isApplicable;
		private final List<? extends FrenchLawAddendumElection> partyElection;
		
		protected FrenchLawAddendumImpl(FrenchLawAddendum.FrenchLawAddendumBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends FrenchLawAddendumElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public FrenchLawAddendum build() {
			return this;
		}
		
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder toBuilder() {
			FrenchLawAddendum.FrenchLawAddendumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FrenchLawAddendum.FrenchLawAddendumBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FrenchLawAddendum _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FrenchLawAddendum {" +
				"isApplicable=" + this.isApplicable + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}

	/*********************** Builder Implementation of FrenchLawAddendum  ***********************/
	class FrenchLawAddendumBuilderImpl implements FrenchLawAddendum.FrenchLawAddendumBuilder {
	
		protected Boolean isApplicable;
		protected List<FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder> partyElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder newPartyElection = FrenchLawAddendumElection.builder();
						return newPartyElection;
					});
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder addPartyElection(FrenchLawAddendumElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder addPartyElection(FrenchLawAddendumElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder addPartyElection(List<? extends FrenchLawAddendumElection> partyElections) {
			if (partyElections != null) {
				for (final FrenchLawAddendumElection toAdd : partyElections) {
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
		public FrenchLawAddendum.FrenchLawAddendumBuilder setPartyElection(List<? extends FrenchLawAddendumElection> partyElections) {
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
		public FrenchLawAddendum build() {
			return new FrenchLawAddendum.FrenchLawAddendumImpl(this);
		}
		
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<FrenchLawAddendumElection.FrenchLawAddendumElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FrenchLawAddendum.FrenchLawAddendumBuilder o = (FrenchLawAddendum.FrenchLawAddendumBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FrenchLawAddendum _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FrenchLawAddendumBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
