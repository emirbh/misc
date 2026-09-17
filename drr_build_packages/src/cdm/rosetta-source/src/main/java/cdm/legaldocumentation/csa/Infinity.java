package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.InfinityMeta;
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
 * Defines that the Threshold is Infinity.
 * @version 6.23.0
 */
@RosettaDataType(value="Infinity", builder=Infinity.InfinityBuilderImpl.class, version="6.23.0")
@RuneDataType(value="Infinity", model="cdm", builder=Infinity.InfinityBuilderImpl.class, version="6.23.0")
public interface Infinity extends RosettaModelObject {

	InfinityMeta metaData = new InfinityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Elective Party to which the condition applies.
	 */
	CounterpartyRoleEnum getParty();

	/*********************** Build Methods  ***********************/
	Infinity build();
	
	Infinity.InfinityBuilder toBuilder();
	
	static Infinity.InfinityBuilder builder() {
		return new Infinity.InfinityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Infinity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Infinity> getType() {
		return Infinity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InfinityBuilder extends Infinity, RosettaModelObjectBuilder {
		Infinity.InfinityBuilder setParty(CounterpartyRoleEnum party);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		}
		

		Infinity.InfinityBuilder prune();
	}

	/*********************** Immutable Implementation of Infinity  ***********************/
	class InfinityImpl implements Infinity {
		private final CounterpartyRoleEnum party;
		
		protected InfinityImpl(Infinity.InfinityBuilder builder) {
			this.party = builder.getParty();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public Infinity build() {
			return this;
		}
		
		@Override
		public Infinity.InfinityBuilder toBuilder() {
			Infinity.InfinityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Infinity.InfinityBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Infinity _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Infinity {" +
				"party=" + this.party +
			'}';
		}
	}

	/*********************** Builder Implementation of Infinity  ***********************/
	class InfinityBuilderImpl implements Infinity.InfinityBuilder {
	
		protected CounterpartyRoleEnum party;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("party")
		@Override
		public Infinity.InfinityBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@Override
		public Infinity build() {
			return new Infinity.InfinityImpl(this);
		}
		
		@Override
		public Infinity.InfinityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Infinity.InfinityBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Infinity.InfinityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Infinity.InfinityBuilder o = (Infinity.InfinityBuilder) other;
			
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Infinity _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InfinityBuilder {" +
				"party=" + this.party +
			'}';
		}
	}
}
