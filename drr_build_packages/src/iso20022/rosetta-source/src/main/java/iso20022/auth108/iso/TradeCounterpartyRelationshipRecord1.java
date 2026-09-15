package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.TradeCounterpartyRelationshipRecord1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the relationship record between two parties.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeCounterpartyRelationshipRecord1", builder=TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeCounterpartyRelationshipRecord1", model="iso20022", builder=TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1BuilderImpl.class, version="${project.version}")
public interface TradeCounterpartyRelationshipRecord1 extends RosettaModelObject {

	TradeCounterpartyRelationshipRecord1Meta metaData = new TradeCounterpartyRelationshipRecord1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies type of counterparty at the start of a directional relationship.
	 */
	TradeCounterpartyType1Code getStartRltshPty();
	/**
	 * Specifies type of counterparty at the end of a directional relationship.
	 */
	TradeCounterpartyType1Code getEndRltshPty();
	/**
	 * Type of relationship between two parties.    Usage: RelationshipType is always in the direction of the StartRelationshipParty to EndRelationshipParty.
	 */
	TradeCounterpartyRelationship1Choice getRltshTp();
	/**
	 * Provides description of other type of relationship between two parties.    Usage: Description is to be used only when RelationshipType is not precisely indicating the type of relationship between parties to the transaction.
	 */
	String getDesc();

	/*********************** Build Methods  ***********************/
	TradeCounterpartyRelationshipRecord1 build();
	
	TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder toBuilder();
	
	static TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder builder() {
		return new TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeCounterpartyRelationshipRecord1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeCounterpartyRelationshipRecord1> getType() {
		return TradeCounterpartyRelationshipRecord1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startRltshPty"), TradeCounterpartyType1Code.class, getStartRltshPty(), this);
		processor.processBasic(path.newSubPath("endRltshPty"), TradeCounterpartyType1Code.class, getEndRltshPty(), this);
		processRosetta(path.newSubPath("rltshTp"), processor, TradeCounterpartyRelationship1Choice.class, getRltshTp());
		processor.processBasic(path.newSubPath("desc"), String.class, getDesc(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeCounterpartyRelationshipRecord1Builder extends TradeCounterpartyRelationshipRecord1, RosettaModelObjectBuilder {
		TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder getOrCreateRltshTp();
		@Override
		TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder getRltshTp();
		TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder setStartRltshPty(TradeCounterpartyType1Code startRltshPty);
		TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder setEndRltshPty(TradeCounterpartyType1Code endRltshPty);
		TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder setRltshTp(TradeCounterpartyRelationship1Choice rltshTp);
		TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder setDesc(String desc);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startRltshPty"), TradeCounterpartyType1Code.class, getStartRltshPty(), this);
			processor.processBasic(path.newSubPath("endRltshPty"), TradeCounterpartyType1Code.class, getEndRltshPty(), this);
			processRosetta(path.newSubPath("rltshTp"), processor, TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder.class, getRltshTp());
			processor.processBasic(path.newSubPath("desc"), String.class, getDesc(), this);
		}
		

		TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder prune();
	}

	/*********************** Immutable Implementation of TradeCounterpartyRelationshipRecord1  ***********************/
	class TradeCounterpartyRelationshipRecord1Impl implements TradeCounterpartyRelationshipRecord1 {
		private final TradeCounterpartyType1Code startRltshPty;
		private final TradeCounterpartyType1Code endRltshPty;
		private final TradeCounterpartyRelationship1Choice rltshTp;
		private final String desc;
		
		protected TradeCounterpartyRelationshipRecord1Impl(TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder builder) {
			this.startRltshPty = builder.getStartRltshPty();
			this.endRltshPty = builder.getEndRltshPty();
			this.rltshTp = ofNullable(builder.getRltshTp()).map(f->f.build()).orElse(null);
			this.desc = builder.getDesc();
		}
		
		@Override
		@RosettaAttribute("startRltshPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startRltshPty")
		public TradeCounterpartyType1Code getStartRltshPty() {
			return startRltshPty;
		}
		
		@Override
		@RosettaAttribute("endRltshPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("endRltshPty")
		public TradeCounterpartyType1Code getEndRltshPty() {
			return endRltshPty;
		}
		
		@Override
		@RosettaAttribute("rltshTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rltshTp")
		public TradeCounterpartyRelationship1Choice getRltshTp() {
			return rltshTp;
		}
		
		@Override
		@RosettaAttribute("desc")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("desc")
		public String getDesc() {
			return desc;
		}
		
		@Override
		public TradeCounterpartyRelationshipRecord1 build() {
			return this;
		}
		
		@Override
		public TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder toBuilder() {
			TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder builder) {
			ofNullable(getStartRltshPty()).ifPresent(builder::setStartRltshPty);
			ofNullable(getEndRltshPty()).ifPresent(builder::setEndRltshPty);
			ofNullable(getRltshTp()).ifPresent(builder::setRltshTp);
			ofNullable(getDesc()).ifPresent(builder::setDesc);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyRelationshipRecord1 _that = getType().cast(o);
		
			if (!Objects.equals(startRltshPty, _that.getStartRltshPty())) return false;
			if (!Objects.equals(endRltshPty, _that.getEndRltshPty())) return false;
			if (!Objects.equals(rltshTp, _that.getRltshTp())) return false;
			if (!Objects.equals(desc, _that.getDesc())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startRltshPty != null ? startRltshPty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (endRltshPty != null ? endRltshPty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rltshTp != null ? rltshTp.hashCode() : 0);
			_result = 31 * _result + (desc != null ? desc.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyRelationshipRecord1 {" +
				"startRltshPty=" + this.startRltshPty + ", " +
				"endRltshPty=" + this.endRltshPty + ", " +
				"rltshTp=" + this.rltshTp + ", " +
				"desc=" + this.desc +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeCounterpartyRelationshipRecord1  ***********************/
	class TradeCounterpartyRelationshipRecord1BuilderImpl implements TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder {
	
		protected TradeCounterpartyType1Code startRltshPty;
		protected TradeCounterpartyType1Code endRltshPty;
		protected TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder rltshTp;
		protected String desc;
		
		@Override
		@RosettaAttribute("startRltshPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startRltshPty")
		public TradeCounterpartyType1Code getStartRltshPty() {
			return startRltshPty;
		}
		
		@Override
		@RosettaAttribute("endRltshPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("endRltshPty")
		public TradeCounterpartyType1Code getEndRltshPty() {
			return endRltshPty;
		}
		
		@Override
		@RosettaAttribute("rltshTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rltshTp")
		public TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder getRltshTp() {
			return rltshTp;
		}
		
		@Override
		public TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder getOrCreateRltshTp() {
			TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder result;
			if (rltshTp!=null) {
				result = rltshTp;
			}
			else {
				result = rltshTp = TradeCounterpartyRelationship1Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("desc")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("desc")
		public String getDesc() {
			return desc;
		}
		
		@RosettaAttribute("startRltshPty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startRltshPty")
		@Override
		public TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder setStartRltshPty(TradeCounterpartyType1Code _startRltshPty) {
			this.startRltshPty = _startRltshPty == null ? null : _startRltshPty;
			return this;
		}
		
		@RosettaAttribute("endRltshPty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endRltshPty")
		@Override
		public TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder setEndRltshPty(TradeCounterpartyType1Code _endRltshPty) {
			this.endRltshPty = _endRltshPty == null ? null : _endRltshPty;
			return this;
		}
		
		@RosettaAttribute("rltshTp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rltshTp")
		@Override
		public TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder setRltshTp(TradeCounterpartyRelationship1Choice _rltshTp) {
			this.rltshTp = _rltshTp == null ? null : _rltshTp.toBuilder();
			return this;
		}
		
		@RosettaAttribute("desc")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("desc")
		@Override
		public TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder setDesc(String _desc) {
			this.desc = _desc == null ? null : _desc;
			return this;
		}
		
		@Override
		public TradeCounterpartyRelationshipRecord1 build() {
			return new TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Impl(this);
		}
		
		@Override
		public TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder prune() {
			if (rltshTp!=null && !rltshTp.prune().hasData()) rltshTp = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartRltshPty()!=null) return true;
			if (getEndRltshPty()!=null) return true;
			if (getRltshTp()!=null && getRltshTp().hasData()) return true;
			if (getDesc()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder o = (TradeCounterpartyRelationshipRecord1.TradeCounterpartyRelationshipRecord1Builder) other;
			
			merger.mergeRosetta(getRltshTp(), o.getRltshTp(), this::setRltshTp);
			
			merger.mergeBasic(getStartRltshPty(), o.getStartRltshPty(), this::setStartRltshPty);
			merger.mergeBasic(getEndRltshPty(), o.getEndRltshPty(), this::setEndRltshPty);
			merger.mergeBasic(getDesc(), o.getDesc(), this::setDesc);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyRelationshipRecord1 _that = getType().cast(o);
		
			if (!Objects.equals(startRltshPty, _that.getStartRltshPty())) return false;
			if (!Objects.equals(endRltshPty, _that.getEndRltshPty())) return false;
			if (!Objects.equals(rltshTp, _that.getRltshTp())) return false;
			if (!Objects.equals(desc, _that.getDesc())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startRltshPty != null ? startRltshPty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (endRltshPty != null ? endRltshPty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rltshTp != null ? rltshTp.hashCode() : 0);
			_result = 31 * _result + (desc != null ? desc.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyRelationshipRecord1Builder {" +
				"startRltshPty=" + this.startRltshPty + ", " +
				"endRltshPty=" + this.endRltshPty + ", " +
				"rltshTp=" + this.rltshTp + ", " +
				"desc=" + this.desc +
			'}';
		}
	}
}
