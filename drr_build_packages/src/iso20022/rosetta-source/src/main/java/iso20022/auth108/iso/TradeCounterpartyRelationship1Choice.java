package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.TradeCounterpartyRelationship1ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the relationship type between parties to the transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeCounterpartyRelationship1Choice", builder=TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeCounterpartyRelationship1Choice", model="iso20022", builder=TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilderImpl.class, version="${project.version}")
public interface TradeCounterpartyRelationship1Choice extends RosettaModelObject {

	TradeCounterpartyRelationship1ChoiceMeta metaData = new TradeCounterpartyRelationship1ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Classification of the party relationship via a pre-determined code list.
	 */
	String getCd();
	/**
	 * Classification of the party relationship using a proprietary identification scheme.
	 */
	String getPrtry();

	/*********************** Build Methods  ***********************/
	TradeCounterpartyRelationship1Choice build();
	
	TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder toBuilder();
	
	static TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder builder() {
		return new TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeCounterpartyRelationship1Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeCounterpartyRelationship1Choice> getType() {
		return TradeCounterpartyRelationship1Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cd"), String.class, getCd(), this);
		processor.processBasic(path.newSubPath("prtry"), String.class, getPrtry(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeCounterpartyRelationship1ChoiceBuilder extends TradeCounterpartyRelationship1Choice, RosettaModelObjectBuilder {
		TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder setCd(String cd);
		TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder setPrtry(String prtry);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cd"), String.class, getCd(), this);
			processor.processBasic(path.newSubPath("prtry"), String.class, getPrtry(), this);
		}
		

		TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of TradeCounterpartyRelationship1Choice  ***********************/
	class TradeCounterpartyRelationship1ChoiceImpl implements TradeCounterpartyRelationship1Choice {
		private final String cd;
		private final String prtry;
		
		protected TradeCounterpartyRelationship1ChoiceImpl(TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder builder) {
			this.cd = builder.getCd();
			this.prtry = builder.getPrtry();
		}
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cd")
		public String getCd() {
			return cd;
		}
		
		@Override
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtry")
		public String getPrtry() {
			return prtry;
		}
		
		@Override
		public TradeCounterpartyRelationship1Choice build() {
			return this;
		}
		
		@Override
		public TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder toBuilder() {
			TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder builder) {
			ofNullable(getCd()).ifPresent(builder::setCd);
			ofNullable(getPrtry()).ifPresent(builder::setPrtry);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyRelationship1Choice _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			if (!Objects.equals(prtry, _that.getPrtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.hashCode() : 0);
			_result = 31 * _result + (prtry != null ? prtry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyRelationship1Choice {" +
				"cd=" + this.cd + ", " +
				"prtry=" + this.prtry +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeCounterpartyRelationship1Choice  ***********************/
	class TradeCounterpartyRelationship1ChoiceBuilderImpl implements TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder {
	
		protected String cd;
		protected String prtry;
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cd")
		public String getCd() {
			return cd;
		}
		
		@Override
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtry")
		public String getPrtry() {
			return prtry;
		}
		
		@RosettaAttribute("cd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cd")
		@Override
		public TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder setCd(String _cd) {
			this.cd = _cd == null ? null : _cd;
			return this;
		}
		
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prtry")
		@Override
		public TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder setPrtry(String _prtry) {
			this.prtry = _prtry == null ? null : _prtry;
			return this;
		}
		
		@Override
		public TradeCounterpartyRelationship1Choice build() {
			return new TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceImpl(this);
		}
		
		@Override
		public TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCd()!=null) return true;
			if (getPrtry()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder o = (TradeCounterpartyRelationship1Choice.TradeCounterpartyRelationship1ChoiceBuilder) other;
			
			
			merger.mergeBasic(getCd(), o.getCd(), this::setCd);
			merger.mergeBasic(getPrtry(), o.getPrtry(), this::setPrtry);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyRelationship1Choice _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			if (!Objects.equals(prtry, _that.getPrtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.hashCode() : 0);
			_result = 31 * _result + (prtry != null ? prtry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyRelationship1ChoiceBuilder {" +
				"cd=" + this.cd + ", " +
				"prtry=" + this.prtry +
			'}';
		}
	}
}
