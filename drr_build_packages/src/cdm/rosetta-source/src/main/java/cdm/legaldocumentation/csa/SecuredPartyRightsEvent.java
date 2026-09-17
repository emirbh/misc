package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.SecuredPartyRightsEventMeta;
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
 * A class to specify Secured Party Rights Event language.
 * @version 6.23.0
 */
@RosettaDataType(value="SecuredPartyRightsEvent", builder=SecuredPartyRightsEvent.SecuredPartyRightsEventBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SecuredPartyRightsEvent", model="cdm", builder=SecuredPartyRightsEvent.SecuredPartyRightsEventBuilderImpl.class, version="6.23.0")
public interface SecuredPartyRightsEvent extends RosettaModelObject {

	SecuredPartyRightsEventMeta metaData = new SecuredPartyRightsEventMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends SecuredPartyRightsEventElection> getSecuredPartyRightsEventElection();
	/**
	 * A boolean attribute to specify whether Failure to Pay Early Termination language is included (True) or excluded (False) from the agreement.
	 */
	Boolean getEarlyTerminationDateOptionalLanguage();
	/**
	 * A boolean attribute to specify whether Failure to Pay Early Termination language in the agreement is deemed applicable or not.
	 */
	Boolean getFailureToPayEarlyTermination();

	/*********************** Build Methods  ***********************/
	SecuredPartyRightsEvent build();
	
	SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder toBuilder();
	
	static SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder builder() {
		return new SecuredPartyRightsEvent.SecuredPartyRightsEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecuredPartyRightsEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecuredPartyRightsEvent> getType() {
		return SecuredPartyRightsEvent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("securedPartyRightsEventElection"), processor, SecuredPartyRightsEventElection.class, getSecuredPartyRightsEventElection());
		processor.processBasic(path.newSubPath("earlyTerminationDateOptionalLanguage"), Boolean.class, getEarlyTerminationDateOptionalLanguage(), this);
		processor.processBasic(path.newSubPath("failureToPayEarlyTermination"), Boolean.class, getFailureToPayEarlyTermination(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecuredPartyRightsEventBuilder extends SecuredPartyRightsEvent, RosettaModelObjectBuilder {
		SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder getOrCreateSecuredPartyRightsEventElection(int index);
		@Override
		List<? extends SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder> getSecuredPartyRightsEventElection();
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder addSecuredPartyRightsEventElection(SecuredPartyRightsEventElection securedPartyRightsEventElection);
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder addSecuredPartyRightsEventElection(SecuredPartyRightsEventElection securedPartyRightsEventElection, int idx);
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder addSecuredPartyRightsEventElection(List<? extends SecuredPartyRightsEventElection> securedPartyRightsEventElection);
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder setSecuredPartyRightsEventElection(List<? extends SecuredPartyRightsEventElection> securedPartyRightsEventElection);
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder setEarlyTerminationDateOptionalLanguage(Boolean earlyTerminationDateOptionalLanguage);
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder setFailureToPayEarlyTermination(Boolean failureToPayEarlyTermination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("securedPartyRightsEventElection"), processor, SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder.class, getSecuredPartyRightsEventElection());
			processor.processBasic(path.newSubPath("earlyTerminationDateOptionalLanguage"), Boolean.class, getEarlyTerminationDateOptionalLanguage(), this);
			processor.processBasic(path.newSubPath("failureToPayEarlyTermination"), Boolean.class, getFailureToPayEarlyTermination(), this);
		}
		

		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder prune();
	}

	/*********************** Immutable Implementation of SecuredPartyRightsEvent  ***********************/
	class SecuredPartyRightsEventImpl implements SecuredPartyRightsEvent {
		private final List<? extends SecuredPartyRightsEventElection> securedPartyRightsEventElection;
		private final Boolean earlyTerminationDateOptionalLanguage;
		private final Boolean failureToPayEarlyTermination;
		
		protected SecuredPartyRightsEventImpl(SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder builder) {
			this.securedPartyRightsEventElection = ofNullable(builder.getSecuredPartyRightsEventElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.earlyTerminationDateOptionalLanguage = builder.getEarlyTerminationDateOptionalLanguage();
			this.failureToPayEarlyTermination = builder.getFailureToPayEarlyTermination();
		}
		
		@Override
		@RosettaAttribute("securedPartyRightsEventElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("securedPartyRightsEventElection")
		public List<? extends SecuredPartyRightsEventElection> getSecuredPartyRightsEventElection() {
			return securedPartyRightsEventElection;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationDateOptionalLanguage")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("earlyTerminationDateOptionalLanguage")
		public Boolean getEarlyTerminationDateOptionalLanguage() {
			return earlyTerminationDateOptionalLanguage;
		}
		
		@Override
		@RosettaAttribute("failureToPayEarlyTermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("failureToPayEarlyTermination")
		public Boolean getFailureToPayEarlyTermination() {
			return failureToPayEarlyTermination;
		}
		
		@Override
		public SecuredPartyRightsEvent build() {
			return this;
		}
		
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder toBuilder() {
			SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder builder) {
			ofNullable(getSecuredPartyRightsEventElection()).ifPresent(builder::setSecuredPartyRightsEventElection);
			ofNullable(getEarlyTerminationDateOptionalLanguage()).ifPresent(builder::setEarlyTerminationDateOptionalLanguage);
			ofNullable(getFailureToPayEarlyTermination()).ifPresent(builder::setFailureToPayEarlyTermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuredPartyRightsEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(securedPartyRightsEventElection, _that.getSecuredPartyRightsEventElection())) return false;
			if (!Objects.equals(earlyTerminationDateOptionalLanguage, _that.getEarlyTerminationDateOptionalLanguage())) return false;
			if (!Objects.equals(failureToPayEarlyTermination, _that.getFailureToPayEarlyTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (securedPartyRightsEventElection != null ? securedPartyRightsEventElection.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationDateOptionalLanguage != null ? earlyTerminationDateOptionalLanguage.hashCode() : 0);
			_result = 31 * _result + (failureToPayEarlyTermination != null ? failureToPayEarlyTermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuredPartyRightsEvent {" +
				"securedPartyRightsEventElection=" + this.securedPartyRightsEventElection + ", " +
				"earlyTerminationDateOptionalLanguage=" + this.earlyTerminationDateOptionalLanguage + ", " +
				"failureToPayEarlyTermination=" + this.failureToPayEarlyTermination +
			'}';
		}
	}

	/*********************** Builder Implementation of SecuredPartyRightsEvent  ***********************/
	class SecuredPartyRightsEventBuilderImpl implements SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder {
	
		protected List<SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder> securedPartyRightsEventElection = new ArrayList<>();
		protected Boolean earlyTerminationDateOptionalLanguage;
		protected Boolean failureToPayEarlyTermination;
		
		@Override
		@RosettaAttribute("securedPartyRightsEventElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("securedPartyRightsEventElection")
		public List<? extends SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder> getSecuredPartyRightsEventElection() {
			return securedPartyRightsEventElection;
		}
		
		@Override
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder getOrCreateSecuredPartyRightsEventElection(int index) {
			if (securedPartyRightsEventElection==null) {
				this.securedPartyRightsEventElection = new ArrayList<>();
			}
			return getIndex(securedPartyRightsEventElection, index, () -> {
						SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder newSecuredPartyRightsEventElection = SecuredPartyRightsEventElection.builder();
						return newSecuredPartyRightsEventElection;
					});
		}
		
		@Override
		@RosettaAttribute("earlyTerminationDateOptionalLanguage")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("earlyTerminationDateOptionalLanguage")
		public Boolean getEarlyTerminationDateOptionalLanguage() {
			return earlyTerminationDateOptionalLanguage;
		}
		
		@Override
		@RosettaAttribute("failureToPayEarlyTermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("failureToPayEarlyTermination")
		public Boolean getFailureToPayEarlyTermination() {
			return failureToPayEarlyTermination;
		}
		
		@RosettaAttribute("securedPartyRightsEventElection")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("securedPartyRightsEventElection")
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder addSecuredPartyRightsEventElection(SecuredPartyRightsEventElection _securedPartyRightsEventElection) {
			if (_securedPartyRightsEventElection != null) {
				this.securedPartyRightsEventElection.add(_securedPartyRightsEventElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder addSecuredPartyRightsEventElection(SecuredPartyRightsEventElection _securedPartyRightsEventElection, int idx) {
			getIndex(this.securedPartyRightsEventElection, idx, () -> _securedPartyRightsEventElection.toBuilder());
			return this;
		}
		
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder addSecuredPartyRightsEventElection(List<? extends SecuredPartyRightsEventElection> securedPartyRightsEventElections) {
			if (securedPartyRightsEventElections != null) {
				for (final SecuredPartyRightsEventElection toAdd : securedPartyRightsEventElections) {
					this.securedPartyRightsEventElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("securedPartyRightsEventElection")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("securedPartyRightsEventElection")
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder setSecuredPartyRightsEventElection(List<? extends SecuredPartyRightsEventElection> securedPartyRightsEventElections) {
			if (securedPartyRightsEventElections == null) {
				this.securedPartyRightsEventElection = new ArrayList<>();
			} else {
				this.securedPartyRightsEventElection = securedPartyRightsEventElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("earlyTerminationDateOptionalLanguage")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("earlyTerminationDateOptionalLanguage")
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder setEarlyTerminationDateOptionalLanguage(Boolean _earlyTerminationDateOptionalLanguage) {
			this.earlyTerminationDateOptionalLanguage = _earlyTerminationDateOptionalLanguage == null ? null : _earlyTerminationDateOptionalLanguage;
			return this;
		}
		
		@RosettaAttribute("failureToPayEarlyTermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("failureToPayEarlyTermination")
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder setFailureToPayEarlyTermination(Boolean _failureToPayEarlyTermination) {
			this.failureToPayEarlyTermination = _failureToPayEarlyTermination == null ? null : _failureToPayEarlyTermination;
			return this;
		}
		
		@Override
		public SecuredPartyRightsEvent build() {
			return new SecuredPartyRightsEvent.SecuredPartyRightsEventImpl(this);
		}
		
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder prune() {
			securedPartyRightsEventElection = securedPartyRightsEventElection.stream().filter(b->b!=null).<SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSecuredPartyRightsEventElection()!=null && getSecuredPartyRightsEventElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEarlyTerminationDateOptionalLanguage()!=null) return true;
			if (getFailureToPayEarlyTermination()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder o = (SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder) other;
			
			merger.mergeRosetta(getSecuredPartyRightsEventElection(), o.getSecuredPartyRightsEventElection(), this::getOrCreateSecuredPartyRightsEventElection);
			
			merger.mergeBasic(getEarlyTerminationDateOptionalLanguage(), o.getEarlyTerminationDateOptionalLanguage(), this::setEarlyTerminationDateOptionalLanguage);
			merger.mergeBasic(getFailureToPayEarlyTermination(), o.getFailureToPayEarlyTermination(), this::setFailureToPayEarlyTermination);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuredPartyRightsEvent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(securedPartyRightsEventElection, _that.getSecuredPartyRightsEventElection())) return false;
			if (!Objects.equals(earlyTerminationDateOptionalLanguage, _that.getEarlyTerminationDateOptionalLanguage())) return false;
			if (!Objects.equals(failureToPayEarlyTermination, _that.getFailureToPayEarlyTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (securedPartyRightsEventElection != null ? securedPartyRightsEventElection.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationDateOptionalLanguage != null ? earlyTerminationDateOptionalLanguage.hashCode() : 0);
			_result = 31 * _result + (failureToPayEarlyTermination != null ? failureToPayEarlyTermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuredPartyRightsEventBuilder {" +
				"securedPartyRightsEventElection=" + this.securedPartyRightsEventElection + ", " +
				"earlyTerminationDateOptionalLanguage=" + this.earlyTerminationDateOptionalLanguage + ", " +
				"failureToPayEarlyTermination=" + this.failureToPayEarlyTermination +
			'}';
		}
	}
}
