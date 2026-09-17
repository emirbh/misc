package cdm.legaldocumentation.transaction;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.transaction.meta.UnderlierSubstitutionProvisionMeta;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Where parties describe any substitution terms.
 * @version 6.23.0
 */
@RosettaDataType(value="UnderlierSubstitutionProvision", builder=UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="UnderlierSubstitutionProvision", model="cdm", builder=UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilderImpl.class, version="6.23.0")
public interface UnderlierSubstitutionProvision extends RosettaModelObject {

	UnderlierSubstitutionProvisionMeta metaData = new UnderlierSubstitutionProvisionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Designates which Counterparty to the transaction who has the right to trigger a substitution or to provide related determination e.g. for instance to qualify the effectiveness of an Event which may be a trigger for substitution, determine the replacement Share to substitute, etc. ; cardinality of this object is 2, in case parties jointly have this role.
	 */
	List<CounterpartyRoleEnum> getWhoMaySubstitute();
	/**
	 * Where parties describe any substitution terms e.g. for instance the election criteria for an Asset to be eligible as the Substitute Asset to the prior Affected Asset in terms of sector of activity, currency, market capitalisation, liquidity, volatility, or any additional features that parties would agree to take into considerations, etc.
	 */
	List<? extends Clause> getSubstitutionBeSpokeTerms();
	/**
	 * Where the parties may optionnally explictly specify the list of Events to be considered as a trigger for a Substitution.
	 */
	List<? extends ExtraordinaryEvents> getSubstitutionTriggerEvents();
	/**
	 * Where the party who is not granted with the substitution role at least has a right to dispute the determination given by the counterparty with such role. As an example, a given PartyA is the unique Counterparty with the Role of WhoMaySubstitute, yet PartyB could be Disputing Party in regard of such Role.
	 */
	CounterpartyRoleEnum getDisputingParty();

	/*********************** Build Methods  ***********************/
	UnderlierSubstitutionProvision build();
	
	UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder toBuilder();
	
	static UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder builder() {
		return new UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnderlierSubstitutionProvision> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UnderlierSubstitutionProvision> getType() {
		return UnderlierSubstitutionProvision.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("whoMaySubstitute"), CounterpartyRoleEnum.class, getWhoMaySubstitute(), this);
		processRosetta(path.newSubPath("substitutionBeSpokeTerms"), processor, Clause.class, getSubstitutionBeSpokeTerms());
		processRosetta(path.newSubPath("substitutionTriggerEvents"), processor, ExtraordinaryEvents.class, getSubstitutionTriggerEvents());
		processor.processBasic(path.newSubPath("disputingParty"), CounterpartyRoleEnum.class, getDisputingParty(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlierSubstitutionProvisionBuilder extends UnderlierSubstitutionProvision, RosettaModelObjectBuilder {
		Clause.ClauseBuilder getOrCreateSubstitutionBeSpokeTerms(int index);
		@Override
		List<? extends Clause.ClauseBuilder> getSubstitutionBeSpokeTerms();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateSubstitutionTriggerEvents(int index);
		@Override
		List<? extends ExtraordinaryEvents.ExtraordinaryEventsBuilder> getSubstitutionTriggerEvents();
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addWhoMaySubstitute(CounterpartyRoleEnum whoMaySubstitute);
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addWhoMaySubstitute(CounterpartyRoleEnum whoMaySubstitute, int idx);
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addWhoMaySubstitute(List<CounterpartyRoleEnum> whoMaySubstitute);
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder setWhoMaySubstitute(List<CounterpartyRoleEnum> whoMaySubstitute);
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addSubstitutionBeSpokeTerms(Clause substitutionBeSpokeTerms);
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addSubstitutionBeSpokeTerms(Clause substitutionBeSpokeTerms, int idx);
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addSubstitutionBeSpokeTerms(List<? extends Clause> substitutionBeSpokeTerms);
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder setSubstitutionBeSpokeTerms(List<? extends Clause> substitutionBeSpokeTerms);
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addSubstitutionTriggerEvents(ExtraordinaryEvents substitutionTriggerEvents);
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addSubstitutionTriggerEvents(ExtraordinaryEvents substitutionTriggerEvents, int idx);
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addSubstitutionTriggerEvents(List<? extends ExtraordinaryEvents> substitutionTriggerEvents);
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder setSubstitutionTriggerEvents(List<? extends ExtraordinaryEvents> substitutionTriggerEvents);
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder setDisputingParty(CounterpartyRoleEnum disputingParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("whoMaySubstitute"), CounterpartyRoleEnum.class, getWhoMaySubstitute(), this);
			processRosetta(path.newSubPath("substitutionBeSpokeTerms"), processor, Clause.ClauseBuilder.class, getSubstitutionBeSpokeTerms());
			processRosetta(path.newSubPath("substitutionTriggerEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getSubstitutionTriggerEvents());
			processor.processBasic(path.newSubPath("disputingParty"), CounterpartyRoleEnum.class, getDisputingParty(), this);
		}
		

		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder prune();
	}

	/*********************** Immutable Implementation of UnderlierSubstitutionProvision  ***********************/
	class UnderlierSubstitutionProvisionImpl implements UnderlierSubstitutionProvision {
		private final List<CounterpartyRoleEnum> whoMaySubstitute;
		private final List<? extends Clause> substitutionBeSpokeTerms;
		private final List<? extends ExtraordinaryEvents> substitutionTriggerEvents;
		private final CounterpartyRoleEnum disputingParty;
		
		protected UnderlierSubstitutionProvisionImpl(UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder builder) {
			this.whoMaySubstitute = ofNullable(builder.getWhoMaySubstitute()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.substitutionBeSpokeTerms = ofNullable(builder.getSubstitutionBeSpokeTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.substitutionTriggerEvents = ofNullable(builder.getSubstitutionTriggerEvents()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.disputingParty = builder.getDisputingParty();
		}
		
		@Override
		@RosettaAttribute("whoMaySubstitute")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("whoMaySubstitute")
		public List<CounterpartyRoleEnum> getWhoMaySubstitute() {
			return whoMaySubstitute;
		}
		
		@Override
		@RosettaAttribute("substitutionBeSpokeTerms")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("substitutionBeSpokeTerms")
		public List<? extends Clause> getSubstitutionBeSpokeTerms() {
			return substitutionBeSpokeTerms;
		}
		
		@Override
		@RosettaAttribute("substitutionTriggerEvents")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("substitutionTriggerEvents")
		public List<? extends ExtraordinaryEvents> getSubstitutionTriggerEvents() {
			return substitutionTriggerEvents;
		}
		
		@Override
		@RosettaAttribute("disputingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disputingParty")
		public CounterpartyRoleEnum getDisputingParty() {
			return disputingParty;
		}
		
		@Override
		public UnderlierSubstitutionProvision build() {
			return this;
		}
		
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder toBuilder() {
			UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder builder) {
			ofNullable(getWhoMaySubstitute()).ifPresent(builder::setWhoMaySubstitute);
			ofNullable(getSubstitutionBeSpokeTerms()).ifPresent(builder::setSubstitutionBeSpokeTerms);
			ofNullable(getSubstitutionTriggerEvents()).ifPresent(builder::setSubstitutionTriggerEvents);
			ofNullable(getDisputingParty()).ifPresent(builder::setDisputingParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnderlierSubstitutionProvision _that = getType().cast(o);
		
			if (!ListEquals.listEquals(whoMaySubstitute, _that.getWhoMaySubstitute())) return false;
			if (!ListEquals.listEquals(substitutionBeSpokeTerms, _that.getSubstitutionBeSpokeTerms())) return false;
			if (!ListEquals.listEquals(substitutionTriggerEvents, _that.getSubstitutionTriggerEvents())) return false;
			if (!Objects.equals(disputingParty, _that.getDisputingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (whoMaySubstitute != null ? whoMaySubstitute.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (substitutionBeSpokeTerms != null ? substitutionBeSpokeTerms.hashCode() : 0);
			_result = 31 * _result + (substitutionTriggerEvents != null ? substitutionTriggerEvents.hashCode() : 0);
			_result = 31 * _result + (disputingParty != null ? disputingParty.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlierSubstitutionProvision {" +
				"whoMaySubstitute=" + this.whoMaySubstitute + ", " +
				"substitutionBeSpokeTerms=" + this.substitutionBeSpokeTerms + ", " +
				"substitutionTriggerEvents=" + this.substitutionTriggerEvents + ", " +
				"disputingParty=" + this.disputingParty +
			'}';
		}
	}

	/*********************** Builder Implementation of UnderlierSubstitutionProvision  ***********************/
	class UnderlierSubstitutionProvisionBuilderImpl implements UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder {
	
		protected List<CounterpartyRoleEnum> whoMaySubstitute = new ArrayList<>();
		protected List<Clause.ClauseBuilder> substitutionBeSpokeTerms = new ArrayList<>();
		protected List<ExtraordinaryEvents.ExtraordinaryEventsBuilder> substitutionTriggerEvents = new ArrayList<>();
		protected CounterpartyRoleEnum disputingParty;
		
		@Override
		@RosettaAttribute("whoMaySubstitute")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("whoMaySubstitute")
		public List<CounterpartyRoleEnum> getWhoMaySubstitute() {
			return whoMaySubstitute;
		}
		
		@Override
		@RosettaAttribute("substitutionBeSpokeTerms")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("substitutionBeSpokeTerms")
		public List<? extends Clause.ClauseBuilder> getSubstitutionBeSpokeTerms() {
			return substitutionBeSpokeTerms;
		}
		
		@Override
		public Clause.ClauseBuilder getOrCreateSubstitutionBeSpokeTerms(int index) {
			if (substitutionBeSpokeTerms==null) {
				this.substitutionBeSpokeTerms = new ArrayList<>();
			}
			return getIndex(substitutionBeSpokeTerms, index, () -> {
						Clause.ClauseBuilder newSubstitutionBeSpokeTerms = Clause.builder();
						return newSubstitutionBeSpokeTerms;
					});
		}
		
		@Override
		@RosettaAttribute("substitutionTriggerEvents")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("substitutionTriggerEvents")
		public List<? extends ExtraordinaryEvents.ExtraordinaryEventsBuilder> getSubstitutionTriggerEvents() {
			return substitutionTriggerEvents;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateSubstitutionTriggerEvents(int index) {
			if (substitutionTriggerEvents==null) {
				this.substitutionTriggerEvents = new ArrayList<>();
			}
			return getIndex(substitutionTriggerEvents, index, () -> {
						ExtraordinaryEvents.ExtraordinaryEventsBuilder newSubstitutionTriggerEvents = ExtraordinaryEvents.builder();
						return newSubstitutionTriggerEvents;
					});
		}
		
		@Override
		@RosettaAttribute("disputingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disputingParty")
		public CounterpartyRoleEnum getDisputingParty() {
			return disputingParty;
		}
		
		@RosettaAttribute("whoMaySubstitute")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("whoMaySubstitute")
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addWhoMaySubstitute(CounterpartyRoleEnum _whoMaySubstitute) {
			if (_whoMaySubstitute != null) {
				this.whoMaySubstitute.add(_whoMaySubstitute);
			}
			return this;
		}
		
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addWhoMaySubstitute(CounterpartyRoleEnum _whoMaySubstitute, int idx) {
			getIndex(this.whoMaySubstitute, idx, () -> _whoMaySubstitute);
			return this;
		}
		
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addWhoMaySubstitute(List<CounterpartyRoleEnum> whoMaySubstitutes) {
			if (whoMaySubstitutes != null) {
				for (final CounterpartyRoleEnum toAdd : whoMaySubstitutes) {
					this.whoMaySubstitute.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("whoMaySubstitute")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("whoMaySubstitute")
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder setWhoMaySubstitute(List<CounterpartyRoleEnum> whoMaySubstitutes) {
			if (whoMaySubstitutes == null) {
				this.whoMaySubstitute = new ArrayList<>();
			} else {
				this.whoMaySubstitute = whoMaySubstitutes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("substitutionBeSpokeTerms")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("substitutionBeSpokeTerms")
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addSubstitutionBeSpokeTerms(Clause _substitutionBeSpokeTerms) {
			if (_substitutionBeSpokeTerms != null) {
				this.substitutionBeSpokeTerms.add(_substitutionBeSpokeTerms.toBuilder());
			}
			return this;
		}
		
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addSubstitutionBeSpokeTerms(Clause _substitutionBeSpokeTerms, int idx) {
			getIndex(this.substitutionBeSpokeTerms, idx, () -> _substitutionBeSpokeTerms.toBuilder());
			return this;
		}
		
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addSubstitutionBeSpokeTerms(List<? extends Clause> substitutionBeSpokeTermss) {
			if (substitutionBeSpokeTermss != null) {
				for (final Clause toAdd : substitutionBeSpokeTermss) {
					this.substitutionBeSpokeTerms.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("substitutionBeSpokeTerms")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("substitutionBeSpokeTerms")
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder setSubstitutionBeSpokeTerms(List<? extends Clause> substitutionBeSpokeTermss) {
			if (substitutionBeSpokeTermss == null) {
				this.substitutionBeSpokeTerms = new ArrayList<>();
			} else {
				this.substitutionBeSpokeTerms = substitutionBeSpokeTermss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("substitutionTriggerEvents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("substitutionTriggerEvents")
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addSubstitutionTriggerEvents(ExtraordinaryEvents _substitutionTriggerEvents) {
			if (_substitutionTriggerEvents != null) {
				this.substitutionTriggerEvents.add(_substitutionTriggerEvents.toBuilder());
			}
			return this;
		}
		
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addSubstitutionTriggerEvents(ExtraordinaryEvents _substitutionTriggerEvents, int idx) {
			getIndex(this.substitutionTriggerEvents, idx, () -> _substitutionTriggerEvents.toBuilder());
			return this;
		}
		
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder addSubstitutionTriggerEvents(List<? extends ExtraordinaryEvents> substitutionTriggerEventss) {
			if (substitutionTriggerEventss != null) {
				for (final ExtraordinaryEvents toAdd : substitutionTriggerEventss) {
					this.substitutionTriggerEvents.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("substitutionTriggerEvents")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("substitutionTriggerEvents")
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder setSubstitutionTriggerEvents(List<? extends ExtraordinaryEvents> substitutionTriggerEventss) {
			if (substitutionTriggerEventss == null) {
				this.substitutionTriggerEvents = new ArrayList<>();
			} else {
				this.substitutionTriggerEvents = substitutionTriggerEventss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("disputingParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("disputingParty")
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder setDisputingParty(CounterpartyRoleEnum _disputingParty) {
			this.disputingParty = _disputingParty == null ? null : _disputingParty;
			return this;
		}
		
		@Override
		public UnderlierSubstitutionProvision build() {
			return new UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionImpl(this);
		}
		
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder prune() {
			substitutionBeSpokeTerms = substitutionBeSpokeTerms.stream().filter(b->b!=null).<Clause.ClauseBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			substitutionTriggerEvents = substitutionTriggerEvents.stream().filter(b->b!=null).<ExtraordinaryEvents.ExtraordinaryEventsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getWhoMaySubstitute()!=null && !getWhoMaySubstitute().isEmpty()) return true;
			if (getSubstitutionBeSpokeTerms()!=null && getSubstitutionBeSpokeTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSubstitutionTriggerEvents()!=null && getSubstitutionTriggerEvents().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDisputingParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder o = (UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder) other;
			
			merger.mergeRosetta(getSubstitutionBeSpokeTerms(), o.getSubstitutionBeSpokeTerms(), this::getOrCreateSubstitutionBeSpokeTerms);
			merger.mergeRosetta(getSubstitutionTriggerEvents(), o.getSubstitutionTriggerEvents(), this::getOrCreateSubstitutionTriggerEvents);
			
			merger.mergeBasic(getWhoMaySubstitute(), o.getWhoMaySubstitute(), (Consumer<CounterpartyRoleEnum>) this::addWhoMaySubstitute);
			merger.mergeBasic(getDisputingParty(), o.getDisputingParty(), this::setDisputingParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnderlierSubstitutionProvision _that = getType().cast(o);
		
			if (!ListEquals.listEquals(whoMaySubstitute, _that.getWhoMaySubstitute())) return false;
			if (!ListEquals.listEquals(substitutionBeSpokeTerms, _that.getSubstitutionBeSpokeTerms())) return false;
			if (!ListEquals.listEquals(substitutionTriggerEvents, _that.getSubstitutionTriggerEvents())) return false;
			if (!Objects.equals(disputingParty, _that.getDisputingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (whoMaySubstitute != null ? whoMaySubstitute.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (substitutionBeSpokeTerms != null ? substitutionBeSpokeTerms.hashCode() : 0);
			_result = 31 * _result + (substitutionTriggerEvents != null ? substitutionTriggerEvents.hashCode() : 0);
			_result = 31 * _result + (disputingParty != null ? disputingParty.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlierSubstitutionProvisionBuilder {" +
				"whoMaySubstitute=" + this.whoMaySubstitute + ", " +
				"substitutionBeSpokeTerms=" + this.substitutionBeSpokeTerms + ", " +
				"substitutionTriggerEvents=" + this.substitutionTriggerEvents + ", " +
				"disputingParty=" + this.disputingParty +
			'}';
		}
	}
}
