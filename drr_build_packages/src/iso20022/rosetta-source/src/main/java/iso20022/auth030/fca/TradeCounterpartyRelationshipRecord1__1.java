package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.TradeCounterpartyRelationshipRecord1__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the relationship record between two parties.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeCounterpartyRelationshipRecord1__1", builder=TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeCounterpartyRelationshipRecord1__1", model="iso20022", builder=TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1BuilderImpl.class, version="${project.version}")
public interface TradeCounterpartyRelationshipRecord1__1 extends RosettaModelObject {

	TradeCounterpartyRelationshipRecord1__1Meta metaData = new TradeCounterpartyRelationshipRecord1__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies type of counterparty at the start of a directional relationship.
	 */
	TradeCounterpartyType1Code__1 getStartRltshPty();
	/**
	 * Specifies type of counterparty at the end of a directional relationship.
	 */
	TradeCounterpartyType1Code__2 getEndRltshPty();
	/**
	 * Type of relationship between two parties.  Usage: RelationshipType is always in the direction of the StartRelationshipParty to EndRelationshipParty.
	 */
	TradeCounterpartyRelationship1Choice__1 getRltshTp();

	/*********************** Build Methods  ***********************/
	TradeCounterpartyRelationshipRecord1__1 build();
	
	TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder toBuilder();
	
	static TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder builder() {
		return new TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeCounterpartyRelationshipRecord1__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeCounterpartyRelationshipRecord1__1> getType() {
		return TradeCounterpartyRelationshipRecord1__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startRltshPty"), TradeCounterpartyType1Code__1.class, getStartRltshPty(), this);
		processor.processBasic(path.newSubPath("endRltshPty"), TradeCounterpartyType1Code__2.class, getEndRltshPty(), this);
		processRosetta(path.newSubPath("rltshTp"), processor, TradeCounterpartyRelationship1Choice__1.class, getRltshTp());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeCounterpartyRelationshipRecord1__1Builder extends TradeCounterpartyRelationshipRecord1__1, RosettaModelObjectBuilder {
		TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder getOrCreateRltshTp();
		@Override
		TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder getRltshTp();
		TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder setStartRltshPty(TradeCounterpartyType1Code__1 startRltshPty);
		TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder setEndRltshPty(TradeCounterpartyType1Code__2 endRltshPty);
		TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder setRltshTp(TradeCounterpartyRelationship1Choice__1 rltshTp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startRltshPty"), TradeCounterpartyType1Code__1.class, getStartRltshPty(), this);
			processor.processBasic(path.newSubPath("endRltshPty"), TradeCounterpartyType1Code__2.class, getEndRltshPty(), this);
			processRosetta(path.newSubPath("rltshTp"), processor, TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder.class, getRltshTp());
		}
		

		TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeCounterpartyRelationshipRecord1__1  ***********************/
	class TradeCounterpartyRelationshipRecord1__1Impl implements TradeCounterpartyRelationshipRecord1__1 {
		private final TradeCounterpartyType1Code__1 startRltshPty;
		private final TradeCounterpartyType1Code__2 endRltshPty;
		private final TradeCounterpartyRelationship1Choice__1 rltshTp;
		
		protected TradeCounterpartyRelationshipRecord1__1Impl(TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder builder) {
			this.startRltshPty = builder.getStartRltshPty();
			this.endRltshPty = builder.getEndRltshPty();
			this.rltshTp = ofNullable(builder.getRltshTp()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("startRltshPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startRltshPty")
		public TradeCounterpartyType1Code__1 getStartRltshPty() {
			return startRltshPty;
		}
		
		@Override
		@RosettaAttribute("endRltshPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("endRltshPty")
		public TradeCounterpartyType1Code__2 getEndRltshPty() {
			return endRltshPty;
		}
		
		@Override
		@RosettaAttribute("rltshTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rltshTp")
		public TradeCounterpartyRelationship1Choice__1 getRltshTp() {
			return rltshTp;
		}
		
		@Override
		public TradeCounterpartyRelationshipRecord1__1 build() {
			return this;
		}
		
		@Override
		public TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder toBuilder() {
			TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder builder) {
			ofNullable(getStartRltshPty()).ifPresent(builder::setStartRltshPty);
			ofNullable(getEndRltshPty()).ifPresent(builder::setEndRltshPty);
			ofNullable(getRltshTp()).ifPresent(builder::setRltshTp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyRelationshipRecord1__1 _that = getType().cast(o);
		
			if (!Objects.equals(startRltshPty, _that.getStartRltshPty())) return false;
			if (!Objects.equals(endRltshPty, _that.getEndRltshPty())) return false;
			if (!Objects.equals(rltshTp, _that.getRltshTp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startRltshPty != null ? startRltshPty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (endRltshPty != null ? endRltshPty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rltshTp != null ? rltshTp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyRelationshipRecord1__1 {" +
				"startRltshPty=" + this.startRltshPty + ", " +
				"endRltshPty=" + this.endRltshPty + ", " +
				"rltshTp=" + this.rltshTp +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeCounterpartyRelationshipRecord1__1  ***********************/
	class TradeCounterpartyRelationshipRecord1__1BuilderImpl implements TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder {
	
		protected TradeCounterpartyType1Code__1 startRltshPty;
		protected TradeCounterpartyType1Code__2 endRltshPty;
		protected TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder rltshTp;
		
		@Override
		@RosettaAttribute("startRltshPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startRltshPty")
		public TradeCounterpartyType1Code__1 getStartRltshPty() {
			return startRltshPty;
		}
		
		@Override
		@RosettaAttribute("endRltshPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("endRltshPty")
		public TradeCounterpartyType1Code__2 getEndRltshPty() {
			return endRltshPty;
		}
		
		@Override
		@RosettaAttribute("rltshTp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rltshTp")
		public TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder getRltshTp() {
			return rltshTp;
		}
		
		@Override
		public TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder getOrCreateRltshTp() {
			TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder result;
			if (rltshTp!=null) {
				result = rltshTp;
			}
			else {
				result = rltshTp = TradeCounterpartyRelationship1Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("startRltshPty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startRltshPty")
		@Override
		public TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder setStartRltshPty(TradeCounterpartyType1Code__1 _startRltshPty) {
			this.startRltshPty = _startRltshPty == null ? null : _startRltshPty;
			return this;
		}
		
		@RosettaAttribute("endRltshPty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endRltshPty")
		@Override
		public TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder setEndRltshPty(TradeCounterpartyType1Code__2 _endRltshPty) {
			this.endRltshPty = _endRltshPty == null ? null : _endRltshPty;
			return this;
		}
		
		@RosettaAttribute("rltshTp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rltshTp")
		@Override
		public TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder setRltshTp(TradeCounterpartyRelationship1Choice__1 _rltshTp) {
			this.rltshTp = _rltshTp == null ? null : _rltshTp.toBuilder();
			return this;
		}
		
		@Override
		public TradeCounterpartyRelationshipRecord1__1 build() {
			return new TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Impl(this);
		}
		
		@Override
		public TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder prune() {
			if (rltshTp!=null && !rltshTp.prune().hasData()) rltshTp = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartRltshPty()!=null) return true;
			if (getEndRltshPty()!=null) return true;
			if (getRltshTp()!=null && getRltshTp().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder o = (TradeCounterpartyRelationshipRecord1__1.TradeCounterpartyRelationshipRecord1__1Builder) other;
			
			merger.mergeRosetta(getRltshTp(), o.getRltshTp(), this::setRltshTp);
			
			merger.mergeBasic(getStartRltshPty(), o.getStartRltshPty(), this::setStartRltshPty);
			merger.mergeBasic(getEndRltshPty(), o.getEndRltshPty(), this::setEndRltshPty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyRelationshipRecord1__1 _that = getType().cast(o);
		
			if (!Objects.equals(startRltshPty, _that.getStartRltshPty())) return false;
			if (!Objects.equals(endRltshPty, _that.getEndRltshPty())) return false;
			if (!Objects.equals(rltshTp, _that.getRltshTp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startRltshPty != null ? startRltshPty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (endRltshPty != null ? endRltshPty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rltshTp != null ? rltshTp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyRelationshipRecord1__1Builder {" +
				"startRltshPty=" + this.startRltshPty + ", " +
				"endRltshPty=" + this.endRltshPty + ", " +
				"rltshTp=" + this.rltshTp +
			'}';
		}
	}
}
