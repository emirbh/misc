package cdm.legaldocumentation.master.isda;

import cdm.legaldocumentation.master.isda.meta.AutomaticEarlyTerminationMeta;
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
 * A class to specify the Automatic Early Termination provision applicable to a Master Agreement.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus MasterAgreement ISDA_MA_1998 1998 Master Agreement  
 * section "6(a)"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus MasterAgreement ISDA_MA_2002 2002 Master Agreement  
 * section "6(a)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="AutomaticEarlyTermination", builder=AutomaticEarlyTermination.AutomaticEarlyTerminationBuilderImpl.class, version="6.23.0")
@RuneDataType(value="AutomaticEarlyTermination", model="cdm", builder=AutomaticEarlyTermination.AutomaticEarlyTerminationBuilderImpl.class, version="6.23.0")
public interface AutomaticEarlyTermination extends RosettaModelObject {

	AutomaticEarlyTerminationMeta metaData = new AutomaticEarlyTerminationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies whether automatic termination applies in the event of certain bankruptcy events.
	 */
	Boolean getFallbackAET();
	/**
	 * Specifies whether indemnity applies in the event AET is applicable to one or both of the parties.
	 */
	Boolean getIndemnity();
	/**
	 * The party election specific to the Automatic Early Termination Clause.
	 */
	List<? extends AutomaticEarlyTerminationElection> getPartyElection();

	/*********************** Build Methods  ***********************/
	AutomaticEarlyTermination build();
	
	AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder toBuilder();
	
	static AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder builder() {
		return new AutomaticEarlyTermination.AutomaticEarlyTerminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AutomaticEarlyTermination> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AutomaticEarlyTermination> getType() {
		return AutomaticEarlyTermination.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fallbackAET"), Boolean.class, getFallbackAET(), this);
		processor.processBasic(path.newSubPath("indemnity"), Boolean.class, getIndemnity(), this);
		processRosetta(path.newSubPath("partyElection"), processor, AutomaticEarlyTerminationElection.class, getPartyElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AutomaticEarlyTerminationBuilder extends AutomaticEarlyTermination, RosettaModelObjectBuilder {
		AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder> getPartyElection();
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder setFallbackAET(Boolean fallbackAET);
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder setIndemnity(Boolean indemnity);
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder addPartyElection(AutomaticEarlyTerminationElection partyElection);
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder addPartyElection(AutomaticEarlyTerminationElection partyElection, int idx);
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder addPartyElection(List<? extends AutomaticEarlyTerminationElection> partyElection);
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder setPartyElection(List<? extends AutomaticEarlyTerminationElection> partyElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fallbackAET"), Boolean.class, getFallbackAET(), this);
			processor.processBasic(path.newSubPath("indemnity"), Boolean.class, getIndemnity(), this);
			processRosetta(path.newSubPath("partyElection"), processor, AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder.class, getPartyElection());
		}
		

		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder prune();
	}

	/*********************** Immutable Implementation of AutomaticEarlyTermination  ***********************/
	class AutomaticEarlyTerminationImpl implements AutomaticEarlyTermination {
		private final Boolean fallbackAET;
		private final Boolean indemnity;
		private final List<? extends AutomaticEarlyTerminationElection> partyElection;
		
		protected AutomaticEarlyTerminationImpl(AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder builder) {
			this.fallbackAET = builder.getFallbackAET();
			this.indemnity = builder.getIndemnity();
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fallbackAET")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fallbackAET")
		public Boolean getFallbackAET() {
			return fallbackAET;
		}
		
		@Override
		@RosettaAttribute("indemnity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("indemnity")
		public Boolean getIndemnity() {
			return indemnity;
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends AutomaticEarlyTerminationElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public AutomaticEarlyTermination build() {
			return this;
		}
		
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder toBuilder() {
			AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder builder) {
			ofNullable(getFallbackAET()).ifPresent(builder::setFallbackAET);
			ofNullable(getIndemnity()).ifPresent(builder::setIndemnity);
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AutomaticEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(fallbackAET, _that.getFallbackAET())) return false;
			if (!Objects.equals(indemnity, _that.getIndemnity())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fallbackAET != null ? fallbackAET.hashCode() : 0);
			_result = 31 * _result + (indemnity != null ? indemnity.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AutomaticEarlyTermination {" +
				"fallbackAET=" + this.fallbackAET + ", " +
				"indemnity=" + this.indemnity + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}

	/*********************** Builder Implementation of AutomaticEarlyTermination  ***********************/
	class AutomaticEarlyTerminationBuilderImpl implements AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder {
	
		protected Boolean fallbackAET;
		protected Boolean indemnity;
		protected List<AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder> partyElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("fallbackAET")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fallbackAET")
		public Boolean getFallbackAET() {
			return fallbackAET;
		}
		
		@Override
		@RosettaAttribute("indemnity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("indemnity")
		public Boolean getIndemnity() {
			return indemnity;
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder newPartyElection = AutomaticEarlyTerminationElection.builder();
						return newPartyElection;
					});
		}
		
		@RosettaAttribute("fallbackAET")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fallbackAET")
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder setFallbackAET(Boolean _fallbackAET) {
			this.fallbackAET = _fallbackAET == null ? null : _fallbackAET;
			return this;
		}
		
		@RosettaAttribute("indemnity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("indemnity")
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder setIndemnity(Boolean _indemnity) {
			this.indemnity = _indemnity == null ? null : _indemnity;
			return this;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder addPartyElection(AutomaticEarlyTerminationElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder addPartyElection(AutomaticEarlyTerminationElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder addPartyElection(List<? extends AutomaticEarlyTerminationElection> partyElections) {
			if (partyElections != null) {
				for (final AutomaticEarlyTerminationElection toAdd : partyElections) {
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
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder setPartyElection(List<? extends AutomaticEarlyTerminationElection> partyElections) {
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
		public AutomaticEarlyTermination build() {
			return new AutomaticEarlyTermination.AutomaticEarlyTerminationImpl(this);
		}
		
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<AutomaticEarlyTerminationElection.AutomaticEarlyTerminationElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFallbackAET()!=null) return true;
			if (getIndemnity()!=null) return true;
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder o = (AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			merger.mergeBasic(getFallbackAET(), o.getFallbackAET(), this::setFallbackAET);
			merger.mergeBasic(getIndemnity(), o.getIndemnity(), this::setIndemnity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AutomaticEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(fallbackAET, _that.getFallbackAET())) return false;
			if (!Objects.equals(indemnity, _that.getIndemnity())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fallbackAET != null ? fallbackAET.hashCode() : 0);
			_result = 31 * _result + (indemnity != null ? indemnity.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AutomaticEarlyTerminationBuilder {" +
				"fallbackAET=" + this.fallbackAET + ", " +
				"indemnity=" + this.indemnity + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
