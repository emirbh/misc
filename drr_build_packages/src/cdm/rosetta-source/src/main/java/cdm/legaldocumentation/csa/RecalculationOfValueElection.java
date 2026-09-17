package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.RecalculationOfValueElectionMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify Recalculation of Value terms that will be applicable.
 * @version 6.23.0
 */
@RosettaDataType(value="RecalculationOfValueElection", builder=RecalculationOfValueElection.RecalculationOfValueElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="RecalculationOfValueElection", model="cdm", builder=RecalculationOfValueElection.RecalculationOfValueElectionBuilderImpl.class, version="6.23.0")
public interface RecalculationOfValueElection extends RosettaModelObject {

	RecalculationOfValueElectionMeta metaData = new RecalculationOfValueElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The procedure for Recalculation of Value.
	 */
	RecalculationOfValueElectionEnum getRecalculationOfValueElection();
	/**
	 * Additional Recalculation of Value terms when specified.
	 */
	String getRecalculationOfValueTerms();

	/*********************** Build Methods  ***********************/
	RecalculationOfValueElection build();
	
	RecalculationOfValueElection.RecalculationOfValueElectionBuilder toBuilder();
	
	static RecalculationOfValueElection.RecalculationOfValueElectionBuilder builder() {
		return new RecalculationOfValueElection.RecalculationOfValueElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RecalculationOfValueElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RecalculationOfValueElection> getType() {
		return RecalculationOfValueElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("recalculationOfValueElection"), RecalculationOfValueElectionEnum.class, getRecalculationOfValueElection(), this);
		processor.processBasic(path.newSubPath("recalculationOfValueTerms"), String.class, getRecalculationOfValueTerms(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RecalculationOfValueElectionBuilder extends RecalculationOfValueElection, RosettaModelObjectBuilder {
		RecalculationOfValueElection.RecalculationOfValueElectionBuilder setParty(CounterpartyRoleEnum party);
		RecalculationOfValueElection.RecalculationOfValueElectionBuilder setRecalculationOfValueElection(RecalculationOfValueElectionEnum recalculationOfValueElection);
		RecalculationOfValueElection.RecalculationOfValueElectionBuilder setRecalculationOfValueTerms(String recalculationOfValueTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("recalculationOfValueElection"), RecalculationOfValueElectionEnum.class, getRecalculationOfValueElection(), this);
			processor.processBasic(path.newSubPath("recalculationOfValueTerms"), String.class, getRecalculationOfValueTerms(), this);
		}
		

		RecalculationOfValueElection.RecalculationOfValueElectionBuilder prune();
	}

	/*********************** Immutable Implementation of RecalculationOfValueElection  ***********************/
	class RecalculationOfValueElectionImpl implements RecalculationOfValueElection {
		private final CounterpartyRoleEnum party;
		private final RecalculationOfValueElectionEnum recalculationOfValueElection;
		private final String recalculationOfValueTerms;
		
		protected RecalculationOfValueElectionImpl(RecalculationOfValueElection.RecalculationOfValueElectionBuilder builder) {
			this.party = builder.getParty();
			this.recalculationOfValueElection = builder.getRecalculationOfValueElection();
			this.recalculationOfValueTerms = builder.getRecalculationOfValueTerms();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("recalculationOfValueElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("recalculationOfValueElection")
		public RecalculationOfValueElectionEnum getRecalculationOfValueElection() {
			return recalculationOfValueElection;
		}
		
		@Override
		@RosettaAttribute("recalculationOfValueTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recalculationOfValueTerms")
		public String getRecalculationOfValueTerms() {
			return recalculationOfValueTerms;
		}
		
		@Override
		public RecalculationOfValueElection build() {
			return this;
		}
		
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder toBuilder() {
			RecalculationOfValueElection.RecalculationOfValueElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RecalculationOfValueElection.RecalculationOfValueElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getRecalculationOfValueElection()).ifPresent(builder::setRecalculationOfValueElection);
			ofNullable(getRecalculationOfValueTerms()).ifPresent(builder::setRecalculationOfValueTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RecalculationOfValueElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(recalculationOfValueElection, _that.getRecalculationOfValueElection())) return false;
			if (!Objects.equals(recalculationOfValueTerms, _that.getRecalculationOfValueTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (recalculationOfValueElection != null ? recalculationOfValueElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (recalculationOfValueTerms != null ? recalculationOfValueTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RecalculationOfValueElection {" +
				"party=" + this.party + ", " +
				"recalculationOfValueElection=" + this.recalculationOfValueElection + ", " +
				"recalculationOfValueTerms=" + this.recalculationOfValueTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of RecalculationOfValueElection  ***********************/
	class RecalculationOfValueElectionBuilderImpl implements RecalculationOfValueElection.RecalculationOfValueElectionBuilder {
	
		protected CounterpartyRoleEnum party;
		protected RecalculationOfValueElectionEnum recalculationOfValueElection;
		protected String recalculationOfValueTerms;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("recalculationOfValueElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("recalculationOfValueElection")
		public RecalculationOfValueElectionEnum getRecalculationOfValueElection() {
			return recalculationOfValueElection;
		}
		
		@Override
		@RosettaAttribute("recalculationOfValueTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recalculationOfValueTerms")
		public String getRecalculationOfValueTerms() {
			return recalculationOfValueTerms;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("recalculationOfValueElection")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("recalculationOfValueElection")
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder setRecalculationOfValueElection(RecalculationOfValueElectionEnum _recalculationOfValueElection) {
			this.recalculationOfValueElection = _recalculationOfValueElection == null ? null : _recalculationOfValueElection;
			return this;
		}
		
		@RosettaAttribute("recalculationOfValueTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("recalculationOfValueTerms")
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder setRecalculationOfValueTerms(String _recalculationOfValueTerms) {
			this.recalculationOfValueTerms = _recalculationOfValueTerms == null ? null : _recalculationOfValueTerms;
			return this;
		}
		
		@Override
		public RecalculationOfValueElection build() {
			return new RecalculationOfValueElection.RecalculationOfValueElectionImpl(this);
		}
		
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getRecalculationOfValueElection()!=null) return true;
			if (getRecalculationOfValueTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RecalculationOfValueElection.RecalculationOfValueElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RecalculationOfValueElection.RecalculationOfValueElectionBuilder o = (RecalculationOfValueElection.RecalculationOfValueElectionBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getRecalculationOfValueElection(), o.getRecalculationOfValueElection(), this::setRecalculationOfValueElection);
			merger.mergeBasic(getRecalculationOfValueTerms(), o.getRecalculationOfValueTerms(), this::setRecalculationOfValueTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RecalculationOfValueElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(recalculationOfValueElection, _that.getRecalculationOfValueElection())) return false;
			if (!Objects.equals(recalculationOfValueTerms, _that.getRecalculationOfValueTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (recalculationOfValueElection != null ? recalculationOfValueElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (recalculationOfValueTerms != null ? recalculationOfValueTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RecalculationOfValueElectionBuilder {" +
				"party=" + this.party + ", " +
				"recalculationOfValueElection=" + this.recalculationOfValueElection + ", " +
				"recalculationOfValueTerms=" + this.recalculationOfValueTerms +
			'}';
		}
	}
}
