package iso20022.auth108.fca;

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
import iso20022.auth108.fca.meta.TradeCounterpartyRelationship1Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the relationship type between parties to the transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeCounterpartyRelationship1Choice__1", builder=TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeCounterpartyRelationship1Choice__1", model="iso20022", builder=TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1BuilderImpl.class, version="${project.version}")
public interface TradeCounterpartyRelationship1Choice__1 extends RosettaModelObject {

	TradeCounterpartyRelationship1Choice__1Meta metaData = new TradeCounterpartyRelationship1Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Classification of the party relationship using a proprietary identification scheme.
	 */
	String getPrtry();

	/*********************** Build Methods  ***********************/
	TradeCounterpartyRelationship1Choice__1 build();
	
	TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder toBuilder();
	
	static TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder builder() {
		return new TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeCounterpartyRelationship1Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeCounterpartyRelationship1Choice__1> getType() {
		return TradeCounterpartyRelationship1Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("prtry"), String.class, getPrtry(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeCounterpartyRelationship1Choice__1Builder extends TradeCounterpartyRelationship1Choice__1, RosettaModelObjectBuilder {
		TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder setPrtry(String prtry);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("prtry"), String.class, getPrtry(), this);
		}
		

		TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeCounterpartyRelationship1Choice__1  ***********************/
	class TradeCounterpartyRelationship1Choice__1Impl implements TradeCounterpartyRelationship1Choice__1 {
		private final String prtry;
		
		protected TradeCounterpartyRelationship1Choice__1Impl(TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder builder) {
			this.prtry = builder.getPrtry();
		}
		
		@Override
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("prtry")
		public String getPrtry() {
			return prtry;
		}
		
		@Override
		public TradeCounterpartyRelationship1Choice__1 build() {
			return this;
		}
		
		@Override
		public TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder toBuilder() {
			TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder builder) {
			ofNullable(getPrtry()).ifPresent(builder::setPrtry);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyRelationship1Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(prtry, _that.getPrtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (prtry != null ? prtry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyRelationship1Choice__1 {" +
				"prtry=" + this.prtry +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeCounterpartyRelationship1Choice__1  ***********************/
	class TradeCounterpartyRelationship1Choice__1BuilderImpl implements TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder {
	
		protected String prtry;
		
		@Override
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("prtry")
		public String getPrtry() {
			return prtry;
		}
		
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("prtry")
		@Override
		public TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder setPrtry(String _prtry) {
			this.prtry = _prtry == null ? null : _prtry;
			return this;
		}
		
		@Override
		public TradeCounterpartyRelationship1Choice__1 build() {
			return new TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Impl(this);
		}
		
		@Override
		public TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrtry()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder o = (TradeCounterpartyRelationship1Choice__1.TradeCounterpartyRelationship1Choice__1Builder) other;
			
			
			merger.mergeBasic(getPrtry(), o.getPrtry(), this::setPrtry);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCounterpartyRelationship1Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(prtry, _that.getPrtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (prtry != null ? prtry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCounterpartyRelationship1Choice__1Builder {" +
				"prtry=" + this.prtry +
			'}';
		}
	}
}
