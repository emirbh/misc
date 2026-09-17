package cdm.legaldocumentation.transaction.additionalterms;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.transaction.Clause;
import cdm.legaldocumentation.transaction.additionalterms.meta.DeterminationRolesAndTermsMeta;
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
 * Defines the roles and related terms which document the agreement of parties about any determination requirements ; mostly about Extraordinary Events, without being necessarily restricted to such scope, as further specified in the particular product at stake e.g. for instance when Calculation Agent is mentioned as the Price Determination Method enumarated value, etc.
 * @version 6.23.0
 */
@RosettaDataType(value="DeterminationRolesAndTerms", builder=DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="DeterminationRolesAndTerms", model="cdm", builder=DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilderImpl.class, version="6.23.0")
public interface DeterminationRolesAndTerms extends RosettaModelObject {

	DeterminationRolesAndTermsMeta metaData = new DeterminationRolesAndTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the enumerated values to specify the determination roles to the transaction. Such roles mostly address any determination that would be required when some Extraordinary Events would happen, for instance qualifying the effectiveness of such event, or when a calculation is required, etc. else any other kind of determination as need be. Yet for clarity, other kinds of determination may be covered by such roles, which are not necessarily restricted to the scope of Extarordinary Events, depending on particular product specifications e.g. for instance when Calculation Agent is mentioned as the Price Determination Method enumarated value, etc.
	 */
	DeterminationRoleEnum getDeterminationRole();
	/**
	 * Designates which Counterparty to the transaction is granted with the particular role ; cardinality of this object is 2, in case parties are both having the same role e.g. jointly CalculationAgent, jointly Determining Party, etc. 
	 */
	List<CounterpartyRoleEnum> getWhoToDetermine();
	/**
	 * Where the party who is not granted with the determination role at least has a right to dispute the determination given by the counterparty with such role. As an example, a given PartyA is the unique Counterparty with the Role of CalculationAgent, yet Party B could be Disputing Party in regard of such Role.
	 */
	CounterpartyRoleEnum getDisputingParty();
	/**
	 * Where parties may optionnaly describe any extra bespoke agreements about fallback procedure attached to a particular determination role. This fallback bespoke paragraph would typically address topics such as : delay for the Disputing Party to notify a disagreement when receiving a determination from the Calculation Agent ; Independent Third Party Dealers election terms e.g. number of Dealers to be jointly elected by the counterparties ; delay for joint election of Dealers by the counterparties ; further fallback election procedure in case of disagreement between parties to jointly elect all the Dealers e.g. typically each party designates 1 Dealer, each a Party Representant, which thus result in 2 Dealers in charge of joint election of 3 other Dealers who will be the final ones to provide the response, each a Final Dealer ; delay for joint election of the Final Dealers by the Party Representants ; fees repartition e.g. typically cost and fees incurred by the election of Dealers are equally shared by the parties ; etc.
	 */
	Clause getFallbackLanguageBespokeTerms();

	/*********************** Build Methods  ***********************/
	DeterminationRolesAndTerms build();
	
	DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder toBuilder();
	
	static DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder builder() {
		return new DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DeterminationRolesAndTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DeterminationRolesAndTerms> getType() {
		return DeterminationRolesAndTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("determinationRole"), DeterminationRoleEnum.class, getDeterminationRole(), this);
		processor.processBasic(path.newSubPath("whoToDetermine"), CounterpartyRoleEnum.class, getWhoToDetermine(), this);
		processor.processBasic(path.newSubPath("disputingParty"), CounterpartyRoleEnum.class, getDisputingParty(), this);
		processRosetta(path.newSubPath("fallbackLanguageBespokeTerms"), processor, Clause.class, getFallbackLanguageBespokeTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DeterminationRolesAndTermsBuilder extends DeterminationRolesAndTerms, RosettaModelObjectBuilder {
		Clause.ClauseBuilder getOrCreateFallbackLanguageBespokeTerms();
		@Override
		Clause.ClauseBuilder getFallbackLanguageBespokeTerms();
		DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder setDeterminationRole(DeterminationRoleEnum determinationRole);
		DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder addWhoToDetermine(CounterpartyRoleEnum whoToDetermine);
		DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder addWhoToDetermine(CounterpartyRoleEnum whoToDetermine, int idx);
		DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder addWhoToDetermine(List<CounterpartyRoleEnum> whoToDetermine);
		DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder setWhoToDetermine(List<CounterpartyRoleEnum> whoToDetermine);
		DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder setDisputingParty(CounterpartyRoleEnum disputingParty);
		DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder setFallbackLanguageBespokeTerms(Clause fallbackLanguageBespokeTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("determinationRole"), DeterminationRoleEnum.class, getDeterminationRole(), this);
			processor.processBasic(path.newSubPath("whoToDetermine"), CounterpartyRoleEnum.class, getWhoToDetermine(), this);
			processor.processBasic(path.newSubPath("disputingParty"), CounterpartyRoleEnum.class, getDisputingParty(), this);
			processRosetta(path.newSubPath("fallbackLanguageBespokeTerms"), processor, Clause.ClauseBuilder.class, getFallbackLanguageBespokeTerms());
		}
		

		DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder prune();
	}

	/*********************** Immutable Implementation of DeterminationRolesAndTerms  ***********************/
	class DeterminationRolesAndTermsImpl implements DeterminationRolesAndTerms {
		private final DeterminationRoleEnum determinationRole;
		private final List<CounterpartyRoleEnum> whoToDetermine;
		private final CounterpartyRoleEnum disputingParty;
		private final Clause fallbackLanguageBespokeTerms;
		
		protected DeterminationRolesAndTermsImpl(DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder builder) {
			this.determinationRole = builder.getDeterminationRole();
			this.whoToDetermine = ofNullable(builder.getWhoToDetermine()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.disputingParty = builder.getDisputingParty();
			this.fallbackLanguageBespokeTerms = ofNullable(builder.getFallbackLanguageBespokeTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("determinationRole")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("determinationRole")
		public DeterminationRoleEnum getDeterminationRole() {
			return determinationRole;
		}
		
		@Override
		@RosettaAttribute("whoToDetermine")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("whoToDetermine")
		public List<CounterpartyRoleEnum> getWhoToDetermine() {
			return whoToDetermine;
		}
		
		@Override
		@RosettaAttribute("disputingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disputingParty")
		public CounterpartyRoleEnum getDisputingParty() {
			return disputingParty;
		}
		
		@Override
		@RosettaAttribute("fallbackLanguageBespokeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackLanguageBespokeTerms")
		public Clause getFallbackLanguageBespokeTerms() {
			return fallbackLanguageBespokeTerms;
		}
		
		@Override
		public DeterminationRolesAndTerms build() {
			return this;
		}
		
		@Override
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder toBuilder() {
			DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder builder) {
			ofNullable(getDeterminationRole()).ifPresent(builder::setDeterminationRole);
			ofNullable(getWhoToDetermine()).ifPresent(builder::setWhoToDetermine);
			ofNullable(getDisputingParty()).ifPresent(builder::setDisputingParty);
			ofNullable(getFallbackLanguageBespokeTerms()).ifPresent(builder::setFallbackLanguageBespokeTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeterminationRolesAndTerms _that = getType().cast(o);
		
			if (!Objects.equals(determinationRole, _that.getDeterminationRole())) return false;
			if (!ListEquals.listEquals(whoToDetermine, _that.getWhoToDetermine())) return false;
			if (!Objects.equals(disputingParty, _that.getDisputingParty())) return false;
			if (!Objects.equals(fallbackLanguageBespokeTerms, _that.getFallbackLanguageBespokeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (determinationRole != null ? determinationRole.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (whoToDetermine != null ? whoToDetermine.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (disputingParty != null ? disputingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fallbackLanguageBespokeTerms != null ? fallbackLanguageBespokeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeterminationRolesAndTerms {" +
				"determinationRole=" + this.determinationRole + ", " +
				"whoToDetermine=" + this.whoToDetermine + ", " +
				"disputingParty=" + this.disputingParty + ", " +
				"fallbackLanguageBespokeTerms=" + this.fallbackLanguageBespokeTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of DeterminationRolesAndTerms  ***********************/
	class DeterminationRolesAndTermsBuilderImpl implements DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder {
	
		protected DeterminationRoleEnum determinationRole;
		protected List<CounterpartyRoleEnum> whoToDetermine = new ArrayList<>();
		protected CounterpartyRoleEnum disputingParty;
		protected Clause.ClauseBuilder fallbackLanguageBespokeTerms;
		
		@Override
		@RosettaAttribute("determinationRole")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("determinationRole")
		public DeterminationRoleEnum getDeterminationRole() {
			return determinationRole;
		}
		
		@Override
		@RosettaAttribute("whoToDetermine")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("whoToDetermine")
		public List<CounterpartyRoleEnum> getWhoToDetermine() {
			return whoToDetermine;
		}
		
		@Override
		@RosettaAttribute("disputingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disputingParty")
		public CounterpartyRoleEnum getDisputingParty() {
			return disputingParty;
		}
		
		@Override
		@RosettaAttribute("fallbackLanguageBespokeTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallbackLanguageBespokeTerms")
		public Clause.ClauseBuilder getFallbackLanguageBespokeTerms() {
			return fallbackLanguageBespokeTerms;
		}
		
		@Override
		public Clause.ClauseBuilder getOrCreateFallbackLanguageBespokeTerms() {
			Clause.ClauseBuilder result;
			if (fallbackLanguageBespokeTerms!=null) {
				result = fallbackLanguageBespokeTerms;
			}
			else {
				result = fallbackLanguageBespokeTerms = Clause.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("determinationRole")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("determinationRole")
		@Override
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder setDeterminationRole(DeterminationRoleEnum _determinationRole) {
			this.determinationRole = _determinationRole == null ? null : _determinationRole;
			return this;
		}
		
		@RosettaAttribute("whoToDetermine")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("whoToDetermine")
		@Override
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder addWhoToDetermine(CounterpartyRoleEnum _whoToDetermine) {
			if (_whoToDetermine != null) {
				this.whoToDetermine.add(_whoToDetermine);
			}
			return this;
		}
		
		@Override
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder addWhoToDetermine(CounterpartyRoleEnum _whoToDetermine, int idx) {
			getIndex(this.whoToDetermine, idx, () -> _whoToDetermine);
			return this;
		}
		
		@Override
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder addWhoToDetermine(List<CounterpartyRoleEnum> whoToDetermines) {
			if (whoToDetermines != null) {
				for (final CounterpartyRoleEnum toAdd : whoToDetermines) {
					this.whoToDetermine.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("whoToDetermine")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("whoToDetermine")
		@Override
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder setWhoToDetermine(List<CounterpartyRoleEnum> whoToDetermines) {
			if (whoToDetermines == null) {
				this.whoToDetermine = new ArrayList<>();
			} else {
				this.whoToDetermine = whoToDetermines.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("disputingParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("disputingParty")
		@Override
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder setDisputingParty(CounterpartyRoleEnum _disputingParty) {
			this.disputingParty = _disputingParty == null ? null : _disputingParty;
			return this;
		}
		
		@RosettaAttribute("fallbackLanguageBespokeTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallbackLanguageBespokeTerms")
		@Override
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder setFallbackLanguageBespokeTerms(Clause _fallbackLanguageBespokeTerms) {
			this.fallbackLanguageBespokeTerms = _fallbackLanguageBespokeTerms == null ? null : _fallbackLanguageBespokeTerms.toBuilder();
			return this;
		}
		
		@Override
		public DeterminationRolesAndTerms build() {
			return new DeterminationRolesAndTerms.DeterminationRolesAndTermsImpl(this);
		}
		
		@Override
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder prune() {
			if (fallbackLanguageBespokeTerms!=null && !fallbackLanguageBespokeTerms.prune().hasData()) fallbackLanguageBespokeTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeterminationRole()!=null) return true;
			if (getWhoToDetermine()!=null && !getWhoToDetermine().isEmpty()) return true;
			if (getDisputingParty()!=null) return true;
			if (getFallbackLanguageBespokeTerms()!=null && getFallbackLanguageBespokeTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder o = (DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder) other;
			
			merger.mergeRosetta(getFallbackLanguageBespokeTerms(), o.getFallbackLanguageBespokeTerms(), this::setFallbackLanguageBespokeTerms);
			
			merger.mergeBasic(getDeterminationRole(), o.getDeterminationRole(), this::setDeterminationRole);
			merger.mergeBasic(getWhoToDetermine(), o.getWhoToDetermine(), (Consumer<CounterpartyRoleEnum>) this::addWhoToDetermine);
			merger.mergeBasic(getDisputingParty(), o.getDisputingParty(), this::setDisputingParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeterminationRolesAndTerms _that = getType().cast(o);
		
			if (!Objects.equals(determinationRole, _that.getDeterminationRole())) return false;
			if (!ListEquals.listEquals(whoToDetermine, _that.getWhoToDetermine())) return false;
			if (!Objects.equals(disputingParty, _that.getDisputingParty())) return false;
			if (!Objects.equals(fallbackLanguageBespokeTerms, _that.getFallbackLanguageBespokeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (determinationRole != null ? determinationRole.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (whoToDetermine != null ? whoToDetermine.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (disputingParty != null ? disputingParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fallbackLanguageBespokeTerms != null ? fallbackLanguageBespokeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeterminationRolesAndTermsBuilder {" +
				"determinationRole=" + this.determinationRole + ", " +
				"whoToDetermine=" + this.whoToDetermine + ", " +
				"disputingParty=" + this.disputingParty + ", " +
				"fallbackLanguageBespokeTerms=" + this.fallbackLanguageBespokeTerms +
			'}';
		}
	}
}
