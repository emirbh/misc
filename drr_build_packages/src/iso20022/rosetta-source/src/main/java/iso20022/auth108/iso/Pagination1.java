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
import iso20022.auth108.iso.meta.Pagination1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Number used to sequence pages when it is not possible for data to be conveyed in a single message and the data has to be split across several pages (messages).
 * @version ${project.version}
 */
@RosettaDataType(value="Pagination1", builder=Pagination1.Pagination1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Pagination1", model="iso20022", builder=Pagination1.Pagination1BuilderImpl.class, version="${project.version}")
public interface Pagination1 extends RosettaModelObject {

	Pagination1Meta metaData = new Pagination1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Page number.
	 */
	String getPgNb();
	/**
	 * Indicates the last page.
	 */
	Boolean getLastPgInd();

	/*********************** Build Methods  ***********************/
	Pagination1 build();
	
	Pagination1.Pagination1Builder toBuilder();
	
	static Pagination1.Pagination1Builder builder() {
		return new Pagination1.Pagination1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Pagination1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Pagination1> getType() {
		return Pagination1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("pgNb"), String.class, getPgNb(), this);
		processor.processBasic(path.newSubPath("lastPgInd"), Boolean.class, getLastPgInd(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface Pagination1Builder extends Pagination1, RosettaModelObjectBuilder {
		Pagination1.Pagination1Builder setPgNb(String pgNb);
		Pagination1.Pagination1Builder setLastPgInd(Boolean lastPgInd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("pgNb"), String.class, getPgNb(), this);
			processor.processBasic(path.newSubPath("lastPgInd"), Boolean.class, getLastPgInd(), this);
		}
		

		Pagination1.Pagination1Builder prune();
	}

	/*********************** Immutable Implementation of Pagination1  ***********************/
	class Pagination1Impl implements Pagination1 {
		private final String pgNb;
		private final Boolean lastPgInd;
		
		protected Pagination1Impl(Pagination1.Pagination1Builder builder) {
			this.pgNb = builder.getPgNb();
			this.lastPgInd = builder.getLastPgInd();
		}
		
		@Override
		@RosettaAttribute("pgNb")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pgNb")
		public String getPgNb() {
			return pgNb;
		}
		
		@Override
		@RosettaAttribute("lastPgInd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lastPgInd")
		public Boolean getLastPgInd() {
			return lastPgInd;
		}
		
		@Override
		public Pagination1 build() {
			return this;
		}
		
		@Override
		public Pagination1.Pagination1Builder toBuilder() {
			Pagination1.Pagination1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Pagination1.Pagination1Builder builder) {
			ofNullable(getPgNb()).ifPresent(builder::setPgNb);
			ofNullable(getLastPgInd()).ifPresent(builder::setLastPgInd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Pagination1 _that = getType().cast(o);
		
			if (!Objects.equals(pgNb, _that.getPgNb())) return false;
			if (!Objects.equals(lastPgInd, _that.getLastPgInd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pgNb != null ? pgNb.hashCode() : 0);
			_result = 31 * _result + (lastPgInd != null ? lastPgInd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Pagination1 {" +
				"pgNb=" + this.pgNb + ", " +
				"lastPgInd=" + this.lastPgInd +
			'}';
		}
	}

	/*********************** Builder Implementation of Pagination1  ***********************/
	class Pagination1BuilderImpl implements Pagination1.Pagination1Builder {
	
		protected String pgNb;
		protected Boolean lastPgInd;
		
		@Override
		@RosettaAttribute("pgNb")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("pgNb")
		public String getPgNb() {
			return pgNb;
		}
		
		@Override
		@RosettaAttribute("lastPgInd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lastPgInd")
		public Boolean getLastPgInd() {
			return lastPgInd;
		}
		
		@RosettaAttribute("pgNb")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("pgNb")
		@Override
		public Pagination1.Pagination1Builder setPgNb(String _pgNb) {
			this.pgNb = _pgNb == null ? null : _pgNb;
			return this;
		}
		
		@RosettaAttribute("lastPgInd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("lastPgInd")
		@Override
		public Pagination1.Pagination1Builder setLastPgInd(Boolean _lastPgInd) {
			this.lastPgInd = _lastPgInd == null ? null : _lastPgInd;
			return this;
		}
		
		@Override
		public Pagination1 build() {
			return new Pagination1.Pagination1Impl(this);
		}
		
		@Override
		public Pagination1.Pagination1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Pagination1.Pagination1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPgNb()!=null) return true;
			if (getLastPgInd()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Pagination1.Pagination1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Pagination1.Pagination1Builder o = (Pagination1.Pagination1Builder) other;
			
			
			merger.mergeBasic(getPgNb(), o.getPgNb(), this::setPgNb);
			merger.mergeBasic(getLastPgInd(), o.getLastPgInd(), this::setLastPgInd);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Pagination1 _that = getType().cast(o);
		
			if (!Objects.equals(pgNb, _that.getPgNb())) return false;
			if (!Objects.equals(lastPgInd, _that.getLastPgInd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pgNb != null ? pgNb.hashCode() : 0);
			_result = 31 * _result + (lastPgInd != null ? lastPgInd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Pagination1Builder {" +
				"pgNb=" + this.pgNb + ", " +
				"lastPgInd=" + this.lastPgInd +
			'}';
		}
	}
}
