package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.SinglePostingPartyMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Where only a single  party is explicitly designated to post collateral, the party which is specified as the sole poster of collateral.
 * @version 6.23.0
 */
@RosettaDataType(value="SinglePostingParty", builder=SinglePostingParty.SinglePostingPartyBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SinglePostingParty", model="cdm", builder=SinglePostingParty.SinglePostingPartyBuilderImpl.class, version="6.23.0")
public interface SinglePostingParty extends RosettaModelObject {

	SinglePostingPartyMeta metaData = new SinglePostingPartyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party acting as the Single Posting Party.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * Utilised where the clause data structure is not able to capture a material aspect of the clause.
	 */
	String getOther();

	/*********************** Build Methods  ***********************/
	SinglePostingParty build();
	
	SinglePostingParty.SinglePostingPartyBuilder toBuilder();
	
	static SinglePostingParty.SinglePostingPartyBuilder builder() {
		return new SinglePostingParty.SinglePostingPartyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SinglePostingParty> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SinglePostingParty> getType() {
		return SinglePostingParty.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("other"), String.class, getOther(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SinglePostingPartyBuilder extends SinglePostingParty, RosettaModelObjectBuilder {
		SinglePostingParty.SinglePostingPartyBuilder setParty(CounterpartyRoleEnum party);
		SinglePostingParty.SinglePostingPartyBuilder setOther(String other);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("other"), String.class, getOther(), this);
		}
		

		SinglePostingParty.SinglePostingPartyBuilder prune();
	}

	/*********************** Immutable Implementation of SinglePostingParty  ***********************/
	class SinglePostingPartyImpl implements SinglePostingParty {
		private final CounterpartyRoleEnum party;
		private final String other;
		
		protected SinglePostingPartyImpl(SinglePostingParty.SinglePostingPartyBuilder builder) {
			this.party = builder.getParty();
			this.other = builder.getOther();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("other")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("other")
		public String getOther() {
			return other;
		}
		
		@Override
		public SinglePostingParty build() {
			return this;
		}
		
		@Override
		public SinglePostingParty.SinglePostingPartyBuilder toBuilder() {
			SinglePostingParty.SinglePostingPartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SinglePostingParty.SinglePostingPartyBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getOther()).ifPresent(builder::setOther);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SinglePostingParty _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SinglePostingParty {" +
				"party=" + this.party + ", " +
				"other=" + this.other +
			'}';
		}
	}

	/*********************** Builder Implementation of SinglePostingParty  ***********************/
	class SinglePostingPartyBuilderImpl implements SinglePostingParty.SinglePostingPartyBuilder {
	
		protected CounterpartyRoleEnum party;
		protected String other;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("other")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("other")
		public String getOther() {
			return other;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("party")
		@Override
		public SinglePostingParty.SinglePostingPartyBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("other")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("other")
		@Override
		public SinglePostingParty.SinglePostingPartyBuilder setOther(String _other) {
			this.other = _other == null ? null : _other;
			return this;
		}
		
		@Override
		public SinglePostingParty build() {
			return new SinglePostingParty.SinglePostingPartyImpl(this);
		}
		
		@Override
		public SinglePostingParty.SinglePostingPartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SinglePostingParty.SinglePostingPartyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getOther()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SinglePostingParty.SinglePostingPartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SinglePostingParty.SinglePostingPartyBuilder o = (SinglePostingParty.SinglePostingPartyBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getOther(), o.getOther(), this::setOther);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SinglePostingParty _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SinglePostingPartyBuilder {" +
				"party=" + this.party + ", " +
				"other=" + this.other +
			'}';
		}
	}
}
